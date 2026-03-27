package com.example.ipv4calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        control();
    }
    EditText [] IP_input = new EditText[4];
    EditText [] Subnet_mask_input = new EditText[4];
    TextView Output;
    Button Execute;
    Button Help;
    Button About;

    public void control()
    {
        Output = findViewById(R.id.Result_label);
        Execute = findViewById(R.id.Execute_button);
        Help = findViewById(R.id.Help_button);
        About = findViewById(R.id.About_button);
        Execute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Execute_action();
            }
        });
        About.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                About_action();
            }
        });
        Help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Help_action();
            }
        });
    }

    public void Execute_action()
    {
        IP_input[0] = findViewById(R.id.IP_input1);
        IP_input[1] = findViewById(R.id.IP_input2);
        IP_input[2] = findViewById(R.id.IP_input3);
        IP_input[3] = findViewById(R.id.IP_input4);
        Subnet_mask_input[0] = findViewById(R.id.Subnet_mask_input1);
        Subnet_mask_input[1] = findViewById(R.id.Subnet_mask_input2);
        Subnet_mask_input[2] = findViewById(R.id.Subnet_mask_input3);
        Subnet_mask_input[3] = findViewById(R.id.Subnet_mask_input4);

        int[] IP = new int[4];
        int[] subnet_mask = new int[4];

        // 第一步：讀取所有輸入並驗證
        for (int i = 0; i < 4; i++) {
            try {
                IP[i] = Integer.parseInt(IP_input[i].getText().toString().trim());
                subnet_mask[i] = Integer.parseInt(Subnet_mask_input[i].getText().toString().trim());

                if (IP[i] < 0 || IP[i] > 255 || subnet_mask[i] < 0 || subnet_mask[i] > 255) {
                    Output.setText("錯誤：IP 和 Subnet Mask 每個部分必須在 0-255 之間");
                    return;
                }
            } catch (NumberFormatException nfe) {
                Output.setText("錯誤：請在每個輸入框中輸入有效的數字 (0-255)");
                return;
            }
        }

        // 第二步：判斷 IP Class
        String IPclass;
        if (IP[0] >= 1 && IP[0] <= 126) {
            IPclass = "Class A";
        } else if (IP[0] >= 128 && IP[0] <= 191) {
            IPclass = "Class B";
        } else if (IP[0] >= 192 && IP[0] <= 223) {
            IPclass = "Class C";
        } else if (IP[0] >= 224 && IP[0] <= 239) {
            IPclass = "Class D (Multicast)";
        } else if (IP[0] >= 240 && IP[0] <= 255) {
            IPclass = "Class E (Reserved)";
        } else {
            IPclass = "Invalid";
        }

        // 第三步：計算 CIDR 表示法（subnet mask 中 1 的數量）
        int cidr = 0;
        for (int i = 0; i < 4; i++) {
            cidr += Integer.bitCount(subnet_mask[i]);
        }

        // 第四步：計算主機數量
        int hostBits = 32 - cidr;
        int totalHosts;
        if (hostBits >= 31) {
            // 避免 overflow
            totalHosts = (int) Math.pow(2, hostBits);
        } else {
            totalHosts = 1 << hostBits;  // 位元運算更快
        }
        int availableHosts = totalHosts - 2;

        // 第五步：計算 Network Address 和 Broadcast Address
        int[] networkAddr = new int[4];
        int[] broadcastAddr = new int[4];

        for (int i = 0; i < 4; i++) {
            networkAddr[i] = IP[i] & subnet_mask[i];
            broadcastAddr[i] = networkAddr[i] | (~subnet_mask[i] & 0xFF);
        }

        // 第六步：計算可用 IP 範圍
        int[] firstHost = networkAddr.clone();
        int[] lastHost = broadcastAddr.clone();

        // 第一個可用 IP 通常是 network address + 1
        // 最後一個可用 IP 通常是 broadcast address - 1
        if (totalHosts > 2) {
            // 增加第一個 host
            firstHost[3] = firstHost[3] + 1;
            // 減少最後一個 host
            lastHost[3] = lastHost[3] - 1;
        }

        // 第七步：顯示結果
        String result = "IP Class: " + IPclass + "\n" +
                "CIDR Notation: /" + cidr + "\n" +
                "Subnet Mask: " + subnet_mask[0] + "." + subnet_mask[1] + "." +
                subnet_mask[2] + "." + subnet_mask[3] + "\n" +
                "Network Address: " + networkAddr[0] + "." + networkAddr[1] + "." +
                networkAddr[2] + "." + networkAddr[3] + "\n" +
                "Broadcast Address: " + broadcastAddr[0] + "." + broadcastAddr[1] + "." +
                broadcastAddr[2] + "." + broadcastAddr[3] + "\n" +
                "Total Hosts: " + totalHosts + "\n" +
                "Available Hosts: " + availableHosts + "\n" +
                "Usable IP Range: " + firstHost[0] + "." + firstHost[1] + "." +
                firstHost[2] + "." + firstHost[3] + " to " +
                lastHost[0] + "." + lastHost[1] + "." + lastHost[2] + "." + lastHost[3];

        Output.setText(result);
    }
    public void About_action()
    {
        Output.setText("This is an IP calculator, it allows you to input IP and subnet mask in the grey box\n" +
                       "This calculator calculate the class and range(s) of subnet(s) available");
    }
    public void Help_action()
    {
        Output.setText("Here is some tips when using this app:\n\n" +
                       "The box only allow entering number lower than 256, else text or number >255, a error message will be shown here\n\n"+
                        "You do not need to enter '.' to seperate the number but enter a 1 digit to 3 digit number to every box\n\n"+
                        "All the box shall be filled and enter execute to start the program");
    }
    public int tobinary(int subnetmask)
    {
        int digit=0;
        boolean next = true;
        if(subnetmask>=128)
        {
            subnetmask=subnetmask-128;
            digit++;
        }

        if(subnetmask>=64)
        {
            subnetmask=subnetmask-64;
            digit++;
        }

        if(subnetmask>=32)
        {
            subnetmask=subnetmask-32;
            digit++;
        }

        if(subnetmask>=16)
        {
            subnetmask=subnetmask-16;
            digit++;
        }

        if(subnetmask>=8)
        {
            subnetmask=subnetmask-8;
            digit++;
        }

        if(subnetmask>=4)
        {
            subnetmask=subnetmask-4;
            digit++;
        }

        if(subnetmask>=2)
        {
            subnetmask=subnetmask-2;
            digit++;
        }

        if(subnetmask>=1)
        {
            subnetmask=subnetmask-1;
            digit++;
        }
        return digit;
    }
    public boolean check_under256(int input)
    {
        if(input < 256)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    public int detecting_sector(int input, int benchmark)
    {
        int accumulator = benchmark;

        while (input > accumulator)
        {
            accumulator = accumulator + benchmark;
        }

        return accumulator-benchmark;
    }
    public int Two_to_the_powerOf(int input)
    {
        int result_of_power = 2;
        for(int i=1;i<input;i++)
        {
            result_of_power=result_of_power*2;
        }
        return result_of_power;
    }
}