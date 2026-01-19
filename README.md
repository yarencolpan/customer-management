# Customer Management Projesi – Geliştirme Günlüğü

## Proje Özeti
Bu proje, müşteriler, ürünler, teklifler ve sözleşmeler üzerinden ilerleyen
basit bir CRM / satış yönetim sistemi geliştirmek amacıyla oluşturulmuştur.

Proje Spring Boot kullanılarak katmanlı mimari ile geliştirilmektedir.

---

## Kullanılan Teknolojiler
- Java
- Spring Boot
- Spring Data JPA
- REST API
- PostgreSQL / MySQL (veritabanı)
- Lombok
- Postman

---

## Proje Mimarisi
Katmanlı mimari kullanılmaktadır:

- **Controller** → API endpointleri
- **Service** → İş mantığı
- **Repository** → Veritabanı erişimi (JPA)
- **Model (Entity)** → Veritabanı tabloları

---

## Şu Ana Kadar Yapılanlar

### 1️⃣ Proje Kurulumu
- Spring Boot projesi oluşturuldu
- Veritabanı bağlantısı yapıldı
- `application.properties` üzerinden JPA yapılandırıldı
- Proje VS Code üzerinde çalışır hale getirildi

---

### 2️⃣ Katmanlı Yapının Oluşturulması
- Controller, Service, Repository ve Model paketleri oluşturuldu
- Katmanların görevleri öğrenildi ve ayrıştırıldı

---

### 3️⃣ Customer Entity ve CRUD
- Customer entity oluşturuldu
- Customer için CRUD işlemleri yazıldı
- REST endpointler oluşturuldu
- Postman ile testler yapıldı

---

### 4️⃣ Audit Alanlarının Tanımlanması
Kurumsal standartlara uygun olması için her tabloda bulunacak audit alanları
Customer entity’sine eklendi.

Tanımlanan alanlar:
- `createdById`
- `createdDate`
- `lastModifiedById`
- `lastModifiedDate`
- `deletedById`

> Not: Bu alanlar şu an **sadece tanımlı** durumdadır.
> Yönlendirme gereği otomatik set etme (PrePersist / Service) henüz yapılmamıştır.
