
# Spring Boot Bank Transactions Services

This project includes services that can be implemented in projects for transaction operations, mainly using inheritance logic developed with spring boot.






## Run Project

Clone project

```bash
  git clone https://github.com/yemreyolcu/bank-transaction-services.git
```

Raise Containers

```bash
  docker-compose up
```

  
When the Spring Boot run process starts, CommandLineRunner bean will be activated and will do the operations in the picture below. These add data to the system at startup and make it easier to test.

![Logo](https://firebasestorage.googleapis.com/v0/b/file-cloud-ed995.appspot.com/o/first.png?alt=media&token=2cfce45e-71ed-4151-b286-bda24625afc8)

then let's check our APIs

    
## API Usage


```http
/api/bank-accounts/{accountNumber}
```

| Status | Type     | Content                |
| :-------- | :------- | :------------------------- |
| `200` | `object` | Returns jwt token  |

Postman Output

![Logo](https://firebasestorage.googleapis.com/v0/b/file-cloud-ed995.appspot.com/o/Screenshot%202023-04-14%20at%2020.13.37.png?alt=media&token=e6f457e0-d6f1-4976-93a5-38f3c670f1ab)

#### Deposit Create

```http
 /api/deposit-transactions/create/{accountNumber}
```

| Status | Type     | Content                |
| :-------- | :------- | :------------------------- |
| `201` | `object` | Returns a deposit |

#### Withdrawal Create

```http
/api/withdrawal-transaction/create/{accountNumber}
```

| Status | Type     | Content                       |
| :-------- | :------- | :-------------------------------- |
| `201`      | `object` | Returns a withdrawal|

#### Bill Payment Create

```http
/phone-bill-payment-transactions/create/{accountNumber}
```

| Status | Type     | Content                       |
| :-------- | :------- | :-------------------------------- |
| `201`      | `object` | Returns a bill payment|




  
## Tests

Run this code for start test cases

![Logo](https://firebasestorage.googleapis.com/v0/b/file-cloud-ed995.appspot.com/o/Screenshot%202023-04-14%20at%2021.08.55.png?alt=media&token=bcbb82aa-58b7-4970-9649-5e097cbc3340)

```bash
./mvnw test -Dtest=BankAccountTest     
```

  
