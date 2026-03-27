

## 📄 README.md (英文版)

```markdown`
# IPv4 Calculator

An **Android application** that performs IPv4 address calculations and subnetting. This tool helps network administrators and students quickly compute network information such as IP class, network address, broadcast address, and usable host ranges.

## 🎯 Purpose

This app demonstrates:
- Android app development with Java
- IPv4 networking concepts (classes, subnetting, CIDR)
- Bitwise operations for network calculations
- User input validation and error handling

## 🚀 Features

### IP Address & Subnet Mask Input
- Enter IPv4 address in **dotted decimal format** using 4 separate input fields
- Enter subnet mask in **dotted decimal format** (e.g., 255.255.255.0)
- Real-time validation (0-255 range check)

### Network Calculations
- **IP Class Detection**: Automatically identifies Class A, B, C, D, or E
- **CIDR Notation**: Calculates prefix length (e.g., /24)
- **Network Address**: The first address in the subnet
- **Broadcast Address**: The last address in the subnet
- **Total Hosts**: Total number of addresses in the subnet
- **Available Hosts**: Usable addresses (total hosts - 2)
- **Usable IP Range**: First and last usable IP addresses

### User Interface
- Clean, simple layout with input fields and buttons
- Error messages for invalid inputs
- Help section with usage tips
- About section with app description

## 🛠️ Built With

- **Language**: Java
- **IDE**: Android Studio
- **Minimum SDK**: API 21 (Android 5.0 Lollipop)
- **Target SDK**: API 33 (Android 13)

## 📁 Project Structure

```
IPV4_Calculator/
├── app/
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/com/example/ipv4calculator/
│   │   │   │   └── MainActivity.java      # Main logic
│   │   │   ├── res/
│   │   │   │   ├── layout/
│   │   │   │   │   └── activity_main.xml  # UI layout
│   │   │   │   └── values/                # Strings, colors, themes
│   │   │   └── AndroidManifest.xml        # App manifest
│   │   └── test/                          # Unit tests
│   ├── build.gradle.kts                   # Module-level build config
│   └── proguard-rules.pro                 # ProGuard rules
├── build.gradle.kts                       # Project-level build config
├── settings.gradle.kts                    # Gradle settings
├── gradle/                                # Gradle wrapper
├── .gitignore                             # Git ignore rules
└── LICENSE                                # MIT License
```

## 🧪 How to Run

### Prerequisites
- Android Studio (latest version recommended)
- Android device (API 21+) or emulator

### Steps
1. **Clone the repository**
   ```bash
   git clone https://github.com/LeoTheAuJai/IPV4_Calculator.git
   ```

2. **Open in Android Studio**
   - Launch Android Studio
   - Click "Open" and select the project folder
   - Wait for Gradle sync to complete

3. **Build and Run**
   - Connect an Android device via USB (enable Developer Options and USB Debugging)
   - Or create an emulator (select a device with API 21+)
   - Click the "Run" button (green triangle)

## 📱 Usage Guide

1. **Enter IP Address**: Fill in the four octets of the IP address (each between 0-255)
2. **Enter Subnet Mask**: Fill in the four octets of the subnet mask (each between 0-255)
3. **Click Execute**: Press the "Execute" button to calculate
4. **View Results**: The results will appear in the text area below

### Example
- **IP Address**: 192.168.1.100
- **Subnet Mask**: 255.255.255.0
- **Results**:
  - IP Class: Class C
  - CIDR: /24
  - Network Address: 192.168.1.0
  - Broadcast Address: 192.168.1.255
  - Usable IP Range: 192.168.1.1 to 192.168.1.254
  - Total Hosts: 256
  - Available Hosts: 254

## 📚 Learning Outcomes

- Understanding IPv4 addressing and subnetting
- Implementing bitwise operations in Android (`&`, `|`, `~`)
- Using `Integer.bitCount()` for CIDR calculation
- Input validation and error handling in Android
- Building a practical utility app with clean UI

## 📄 License

This project is licensed under the MIT License. See the `LICENSE` file for details.

## 📬 Contact

Created by **Au Sai Chun**  
Feel free to reach out via [GitHub](https://github.com/LeoTheAuJai).


## 📄 README.zh.md (中文版)

```markdown`
# IPv4 計算機

一個用於執行 **IPv4 位址計算** 和 **子網劃分** 的 Android 應用程式。此工具幫助網路管理員和學生快速計算 IP 類別、網路位址、廣播位址以及可用主機範圍。

## 🎯 程式目的

此應用程式展示：
- 使用 Java 進行 Android 應用開發
- IPv4 網路概念（IP 類別、子網劃分、CIDR）
- 網路計算的位元運算
- 使用者輸入驗證與錯誤處理

## 🚀 功能特色

### IP 位址與子網遮罩輸入
- 使用 **4 個獨立輸入框** 輸入點分十進制格式的 IPv4 位址
- 使用 **4 個獨立輸入框** 輸入點分十進制格式的子網遮罩（如 255.255.255.0）
- 即時驗證（0-255 範圍檢查）

### 網路計算
- **IP 類別檢測**：自動識別 Class A、B、C、D、E
- **CIDR 表示法**：計算前綴長度（如 /24）
- **網路位址**：子網中的第一個位址
- **廣播位址**：子網中的最後一個位址
- **主機總數**：子網中的總位址數
- **可用主機數**：可使用的位址數（主機總數 - 2）
- **可用 IP 範圍**：第一個和最後一個可用的 IP 位址

### 使用者介面
- 簡潔的輸入介面，包含輸入框與按鈕
- 無效輸入時顯示錯誤訊息
- 使用提示的說明頁面
- 應用程式說明的關於頁面

## 🛠️ 使用技術

- **語言**：Java
- **IDE**：Android Studio
- **最低 SDK**：API 21 (Android 5.0 Lollipop)
- **目標 SDK**：API 33 (Android 13)

## 📁 專案結構

```
IPV4_Calculator/
├── app/
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/com/example/ipv4calculator/
│   │   │   │   └── MainActivity.java      # 主要邏輯
│   │   │   ├── res/
│   │   │   │   ├── layout/
│   │   │   │   │   └── activity_main.xml  # UI 佈局
│   │   │   │   └── values/                # 字串、顏色、主題
│   │   │   └── AndroidManifest.xml        # 應用程式清單
│   │   └── test/                          # 單元測試
│   ├── build.gradle.kts                   # 模組級建置設定
│   └── proguard-rules.pro                 # ProGuard 規則
├── build.gradle.kts                       # 專案級建置設定
├── settings.gradle.kts                    # Gradle 設定
├── gradle/                                # Gradle wrapper
├── .gitignore                             # Git 忽略規則
└── LICENSE                                # MIT 授權條款
```

## 🧪 如何執行

### 環境需求
- Android Studio（建議最新版本）
- Android 裝置（API 21+）或模擬器

### 步驟
1. **複製專案**
   ```bash
   git clone https://github.com/LeoTheAuJai/IPV4_Calculator.git
   ```

2. **在 Android Studio 中開啟**
   - 啟動 Android Studio
   - 點擊「Open」，選擇專案資料夾
   - 等待 Gradle 同步完成

3. **建置並執行**
   - 透過 USB 連接 Android 裝置（開啟開發者選項和 USB 偵錯）
   - 或建立模擬器（選擇 API 21+ 的裝置）
   - 點擊「Run」按鈕（綠色三角形）

## 📱 使用說明

1. **輸入 IP 位址**：填寫 IP 位址的四個十進制數字（每個介於 0-255）
2. **輸入子網遮罩**：填寫子網遮罩的四個十進制數字（每個介於 0-255）
3. **點擊執行**：按下「Execute」按鈕開始計算
4. **查看結果**：結果會顯示在下方的文字區域

### 範例
- **IP 位址**：192.168.1.100
- **子網遮罩**：255.255.255.0
- **計算結果**：
  - IP 類別：Class C
  - CIDR：/24
  - 網路位址：192.168.1.0
  - 廣播位址：192.168.1.255
  - 可用 IP 範圍：192.168.1.1 至 192.168.1.254
  - 主機總數：256
  - 可用主機數：254

## 📚 學習成果

- 理解 IPv4 位址與子網劃分
- 在 Android 中實作位元運算（`&`、`|`、`~`）
- 使用 `Integer.bitCount()` 計算 CIDR
- Android 中的輸入驗證與錯誤處理
- 建構實用的工具類應用程式

## 📄 授權條款

本專案採用 MIT 授權條款。詳細內容請參閱 `LICENSE` 檔案。

## 📬 聯絡我

開發者：**區世俊**  
歡迎透過 [GitHub](https://github.com/LeoTheAuJai) 與我聯繫。
