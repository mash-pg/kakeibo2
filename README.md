# Kakeibo2 - 家計簿 API

## 概要

Spring Boot で作成した家計簿管理用の REST API です。

## 技術スタック

- Java 17
- Spring Boot 3.5
- Spring Data JPA
- H2 Database
- Lombok
- Swagger UI (springdoc-openapi)

## 起動方法



## API ドキュメント

起動後、以下の URL でアクセス：

http://localhost:8080/swagger-ui.html

## エンドポイント

| メソッド | パス | 説明 |
|---------|------|------|
| GET | /api/transactions | 取引一覧取得 |
| POST | /api/transactions | 取引作成 |
| PUT | /api/transactions/{id} | 取引更新 |
| DELETE | /api/transactions/{id} | 取引削除 |
| GET | /api/transactions/summary | 集計 |
| GET | /api/categories | カテゴリ一覧取得 |
| POST | /api/categories | カテゴリ作成 |

## 学習内容

このプロジェクトで学んだこと：

- レイヤードアーキテクチャ（Presentation / Application / Domain / Infrastructure）
- DDD 軽量版（Entity, Value Object, Repository）
- デザインパターン（Factory, Strategy）
- テスト（JUnit, Mockito, MockMvc）
- Git フロー（feature ブランチ, PR, レビュー）