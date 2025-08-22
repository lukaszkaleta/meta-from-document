import { html } from 'lit'
import './receipt-card'

export default {
  title: 'ai-docs/invoice/hvd-receipt-card',
  tags: ['autodocs'],
  render: args => html`
    <hvd-receipt-card .receipt=${args.data.receipt}></hvd-receipt-card>
  `,
  argTypes: {
    data: { type: 'object', description: 'Data object' }
  }
}

export const Full = {
  args: {
    data: {
      "inputDocument": {
        "id": "1",
        "url": "https://storage.googleapis.com/ai-hackathon-2024/Examples-sorted/receipt/kvittot_107876510.jpg",
        "fileName": null,
        "contentType": "image/jpeg"
      },
      "invoice": null,
      "receipt": {
        "creditCardLastFourDigits": null,
        "currency": "",
        "endDate": null,
        "netAmount": 207.41,
        "paymentAuthorizationId": null,
        "receiptDate": "2006-11-24",
        "paymentType": null,
        "purchaseTime": null,
        "receiptSate": null,
        "reservationId": null,
        "startDate": null,
        "supplierAddress": null,
        "supplierCity": null,
        "supplierName": "Maxi Ica Stormarknad",
        "supplierPhone": null,
        "tipAmount": null,
        "totalAmount": 276.5,
        "totalTaxAmount": null,
        "travelerName": null,
        "lineItem": [
          {
            "amount": 4.9,
            "description": "Baguette 6-pack",
            "productCode": null,
            "quantity": null,
            "transactionDate": null
          },
          {
            "amount": 7.9,
            "description": "Choco Chip",
            "productCode": null,
            "quantity": null,
            "transactionDate": null
          },
          {
            "amount": 49,
            "description": "Chocolate Fudge Br",
            "productCode": null,
            "quantity": null,
            "transactionDate": null
          },
          {
            "amount": 42,
            "description": "Cig Gold100s Marlb",
            "productCode": null,
            "quantity": null,
            "transactionDate": null
          },
          {
            "amount": 10.9,
            "description": "Fusilli Fullkorn",
            "productCode": null,
            "quantity": null,
            "transactionDate": null
          },
          {
            "amount": 16.3,
            "description": "Kravagg",
            "productCode": null,
            "quantity": null,
            "transactionDate": null
          },
          {
            "amount": 1.65,
            "description": "Kronjäst söt deg",
            "productCode": null,
            "quantity": null,
            "transactionDate": null
          },
          {
            "amount": 2,
            "description": "Pappersbärkasse",
            "productCode": null,
            "quantity": null,
            "transactionDate": null
          },
          {
            "amount": 32.9,
            "description": "Pepsi 4 pack",
            "productCode": null,
            "quantity": null,
            "transactionDate": null
          },
          {
            "amount": 8,
            "description": "+ Pant",
            "productCode": null,
            "quantity": null,
            "transactionDate": null
          },
          {
            "amount": 22.9,
            "description": "Potatisgratäng",
            "productCode": null,
            "quantity": null,
            "transactionDate": null
          },
          {
            "amount": 15.9,
            "description": "Rund & God Solros",
            "productCode": null,
            "quantity": null,
            "transactionDate": null
          },
          {
            "amount": 21.8,
            "description": "Saffran påse",
            "productCode": null,
            "quantity": null,
            "transactionDate": null
          },
          {
            "amount": 13.5,
            "description": "Sirap vit",
            "productCode": null,
            "quantity": null,
            "transactionDate": null
          },
          {
            "amount": 6.95,
            "description": "Standardnjolk",
            "productCode": null,
            "quantity": null,
            "transactionDate": null
          },
          {
            "amount": 9.8,
            "description": "Tonfisk fin vatte 2st",
            "productCode": null,
            "quantity": null,
            "transactionDate": null
          },
          {
            "amount": 9.9,
            "description": null,
            "productCode": null,
            "quantity": null,
            "transactionDate": null
          }
        ]
      },
      "processTime": 4282236750
    }
  }
}
