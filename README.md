# backend_data_management

データ管理を担当するサービス。  
PostgreSQL と接続し、パスワード期限切れ情報などを提供します。

---

## 📦 役割

- DB からのデータ取得
- Entity / Repository / Service 層
- backend_ui からの中継リクエストに応答

---

## 🔗 主な API

| Method | Path | Description |
|--------|------|-------------|
| GET | `/expired/all` | パスワード期限切れ一覧取得 |

---

## 🗂 DB テーブル（pswd_expired）

| Column | Type |
|--------|------|
| pswd_expired_id | int |
| access_info | text |
| user_id | text |
| password | text |
| create_time | timestamp |
| updated_time | timestamp |

---

## 🚀 起動
sh start_data.sh


ポート：**9001**

---

## 🧩 技術

- Spring Boot 3.x
- Spring Data JPA
- PostgreSQL
- backend_common の DTO を利用

