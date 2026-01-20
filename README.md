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

### 5️⃣ Product Entity ve CRUD
- Product entity oluşturuldu
- Ürün bilgileri için temel alanlar tanımlandı (`name`, `unitPrice`)
- Product için CRUD işlemleri yazıldı
- Controller, Service ve Repository katmanları oluşturuldu
- Ürün ekleme, listeleme, güncelleme ve silme işlemleri Postman ile test edildi

---

### 6️⃣ Offer (Teklif) Entity ve CRUD
- Offer entity oluşturuldu
- Teklifin hangi müşteriye ait olduğunu belirtmek için `customerId` alanı tanımlandı
- Teklif onay durumunu tutmak için `isApproved` alanı eklendi
- Offer için CRUD işlemleri yazıldı ve test edildi
- Offer yapısı, ileride sözleşmeye dönüşecek iş akışına uygun şekilde tasarlandı

---

### 7️⃣ OfferItem (Teklif Kalemleri) Entity ve CRUD
- OfferItem entity oluşturuldu
- Teklif içerisindeki ürün satırlarını temsil eden yapı kuruldu

Tanımlanan alanlar:
- `offerId` → hangi teklife ait olduğu
- `productId` → hangi ürün
- `quantity` → ürün adedi
- `unitPrice` → teklif anındaki birim fiyat

- **OfferItemRepository** oluşturuldu
    - Bir teklife ait tüm kalemleri getirmek için  
      `findByOfferId(Long offerId)` metodu yazıldı

- **OfferItemService** oluşturuldu
    - CRUD işlemleri yazıldı
    - `unitPrice` gönderilmezse, ürünün fiyatı `ProductService` üzerinden otomatik olarak alındı

- **OfferItemController** oluşturuldu
    - Teklif kalemi ekleme
    - Tüm kalemleri listeleme
    - ID ile kalem getirme
    - Teklife göre kalemleri listeleme
    - Güncelleme ve silme endpoint’leri yazıldı

- Postman testleri yapıldı
    - Product → Offer → OfferItem sıralı iş akışı doğrulandı
    - Bir teklif içine birden fazla ürün eklenebildiği test edildi

> **Not:**  
> OfferItem ile olan ilişkiler şu an **ID (Long) üzerinden** yönetilmektedir.  
> JPA ilişki anotasyonları (`@ManyToOne`, `@OneToMany`) bilinçli olarak kullanılmamıştır.  
>Amaç, yapıyı sade tutmak ve temel iş akışını öğrenmektir.
>
- Offer approve (teklif onaylama) akışına geçildi
    - Teklif onaylama işleminin bir CRUD update değil, iş aksiyonu (business action) olduğu öğrenildi
    - Bu nedenle `POST /offers/{id}/approve` endpoint’i tasarlandı

- Approve endpoint mantığı yazıldı
    - Offer, ID ile veritabanından alınıyor
    - Teklif zaten onaylıysa hata fırlatılıyor
    - Onaylı değilse `isApproved = true` yapılıyor
    - Güncellenen Offer veritabanına kaydediliyor

- Contract (Sözleşme) kavramı netleştirildi
    - Offer (teklif) ile Contract (sözleşme) arasındaki fark öğrenildi
    - Contract’ın, onaylanan teklifin bağlayıcı hali olduğu belirlendi
    - Sözleşme ve teklifin ayrı entity’ler olması gerektiği anlaşıldı

- Contract entity oluşturuldu
    - `offerId` → hangi tekliften oluştuğu
    - `isSigned` → sözleşmenin imzalanıp imzalanmadığı
    - Audit alanları (şimdilik sadece tanım olarak) eklendi

- ContractRepository oluşturuldu
    - `findByOfferId(Long offerId)` metodu yazıldı
    - Aynı teklif için birden fazla sözleşme oluşturulmasının önüne geçilmesi hedeflendi
    - Bu metot ile `Optional` kavramı öğrenildi

- Optional kullanımı öğrenildi
    - `Optional`’ın “olabilir / olmayabilir” anlamına geldiği anlaşıldı
    - `isPresent()` ve `ifPresent()` arasındaki fark öğrenildi
    - Yanlış `isPresent(c -> {...})` kullanımının hataya sebep olduğu görüldü

- ContractService oluşturuldu
    - Teklif onaylandığında sözleşme oluşturma metodu yazıldı
    - Aynı offerId için sözleşme varsa hata fırlatıldı
    - Yoksa yeni Contract oluşturulup kaydedildi

- ContractController ihtiyacı değerlendirildi
    - Contract’ın manuel oluşturulmadığı, approve ile otomatik oluştuğu netleşti
    - Buna rağmen sözleşmeleri görüntülemek ve imzalamak için controller gerektiği anlaşıldı

- Sözleşme imzalama (sign) endpoint’i tasarlandı
    - `POST /contracts/{id}/sign` endpoint’i yazıldı
    - PUT yerine POST kullanılmasının nedeni öğrenildi
    - İmzalamanın bir alan güncellemesi değil, iş aksiyonu olduğu netleştirildi

- POST kullanmanın sağladığı faydalar anlaşıldı
    - Endpoint’in niyetinin daha net olması
    - İş kurallarının tek yerde toplanabilmesi
    - İleride yetkilendirme ve loglama için uygun yapı kurulması

