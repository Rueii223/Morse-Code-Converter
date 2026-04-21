# Morse-Code-Converter
「一個基於 Java 實作的摩斯密碼轉換工具，支援英文字母與數字的雙向編碼與解碼。」
"A Java-based Morse Code converter supporting bidirectional encoding and decoding for alphanumeric characters."

這是一個簡單的 Java 工具類，用於實現英文字母、數字與摩斯密碼（Morse Code）之間的雙向轉換。

## 功能特色
字母轉碼：支持 A-Z 與 0-9 的摩斯密碼轉換。
解碼功能：可透過摩斯密碼字串反查對應的字元。
高效查詢：使用 `HashMap` 儲存對應表，提供快速的檢索速度。

## 如何使用
你可以直接調用 `MorseCodes` 類別中的靜態方法：

```java
// 取得字母 'A' 的摩斯密碼
String code = MorseCodes.getCode('A'); // 回傳 ".-"

// 取得摩斯密碼 "-..." 對應的字元
String char = MorseCodes.getCharacter("-..."); // 回傳 "B"
