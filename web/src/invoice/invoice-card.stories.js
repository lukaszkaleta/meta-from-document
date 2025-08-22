import { html } from 'lit'
import './invoice-card'

export default {
  title: 'ai-docs/invoice/hvd-invoice-card',
  tags: ['autodocs'],
  render: args => html`
    <hvd-invoice-card .invoice=${args.data.invoice}></hvd-invoice-card>
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
        "url": "https://storage.googleapis.com/ai-hackathon-2024/Examples/0122626300540903__12003.pdf",
        "contentType": "application/pdf"
      },
      "invoice": {
        "invoiceType": "",
        "amountDue": null,
        "amountPaidSinceLastInvoice": null,
        "carrier": null,
        "currency": "DKK",
        "currencyExchangeRate": null,
        "customerTaxId": null,
        "deliveryDate": "2023-05-12",
        "dueDate": "2024-03-02",
        "freightAmount": null,
        "invoiceDate": "2023-05-12",
        "invoiceId": "1226263",
        "netAmount": 19255.83,
        "paymentTerms": null,
        "purchaseOrder": null,
        "receiverAddress": "ELIARSIP AQQ 1 BOX 32\n3911 \nSISIMIUT",
        "receiverEmail": null,
        "receiverName": "SIRIUS GREENLAND APS",
        "receiverPhone": null,
        "receiverTaxId": null,
        "receiverWebsite": null,
        "remitToAddress": null,
        "remitToName": null,
        "shipFromAddress": null,
        "shipFromName": null,
        "shipToAddress": "ELIARSIP AQQ 1 BOX 32\n3911 SISIMIUT\nGREENLAND",
        "shipToName": "SIRIUS GREENLAND APS\nBO LINGS",
        "supplierAddress": null,
        "supplierEmail": null,
        "supplierIban": null,
        "supplierName": "YAMAHA MOTOR DANMARK\nfilial af Yamaha Motor Europe N.V., Holland",
        "supplierPaymentRef": null,
        "supplierPhone": "+45 63 10 95 00",
        "supplierRegistration": null,
        "supplierTaxId": "NL001620022B01",
        "supplierWebsite": "www.yamaha-motor.dk",
        "totalAmount": 19256,
        "totalTaxAmount": 0,
        "lineItem": [
          {
            "amount": 529.92,
            "description": "CONTROL CABLE 12 FT\nLager",
            "productCode": "YMEEC1331210",
            "purchaseOrder": null,
            "quantity": 4,
            "unit": "ST",
            "unitPrice": 220.8
          },
          {
            "amount": 602.88,
            "description": "OB - CONTROL CABLE 15 FT\nLager",
            "productCode": "YMEEC1331510",
            "purchaseOrder": null,
            "quantity": 4,
            "unit": "ST",
            "unitPrice": 251.2
          },
          {
            "amount": null,
            "description": "Ordre: 869830 Deres reference: 1286Sig\nLager/Kunder",
            "productCode": null,
            "purchaseOrder": null,
            "quantity": null,
            "unit": null,
            "unitPrice": null
          },
          {
            "amount": 485.76,
            "description": "CONTROL CABLE 10 FT\nLager",
            "productCode": "YMEEC1331010",
            "purchaseOrder": null,
            "quantity": 4,
            "unit": "ST",
            "unitPrice": 202.4
          },
          {
            "amount": 624,
            "description": "OB - CONTROL CABLE 16 FT\nLager",
            "productCode": "YMEEC1331610",
            "purchaseOrder": null,
            "quantity": 4,
            "unit": "ST",
            "unitPrice": 260
          },
          {
            "amount": 1720.8,
            "description": "CONTROL CABLE 09 FT\n10 stk. KNI 70607500",
            "productCode": "YMEEC1330910 OB",
            "purchaseOrder": null,
            "quantity": 15,
            "unit": "ST",
            "unitPrice": 191.2
          },
          {
            "amount": 2211.84,
            "description": "CONTROL CABLE 13 FT\n6 stk. KNI 70627069",
            "productCode": "YMEEC1331310 OB",
            "purchaseOrder": null,
            "quantity": 16,
            "unit": "ST",
            "unitPrice": 230.4
          },
          {
            "amount": 1214.4,
            "description": "IMPELLER",
            "productCode": "6E5443520100",
            "purchaseOrder": null,
            "quantity": 5,
            "unit": "ST",
            "unitPrice": 404.8
          },
          {
            "amount": 4806.12,
            "description": "BALL JOINT SET\nPolaroil Qaanaaq",
            "productCode": "1CT2510F0200",
            "purchaseOrder": null,
            "quantity": 2,
            "unit": "ST",
            "unitPrice": 3204.08
          },
          {
            "amount": 3663.48,
            "description": "DOUBLE OFF SET JOINT\nPolaroil Qaanaaq",
            "productCode": "1CT2530V0100",
            "purchaseOrder": null,
            "quantity": 2,
            "unit": "ST",
            "unitPrice": 2616.77
          },
          {
            "amount": 2298.39,
            "description": "V-BELT\n1 stk. Polaroil Qaanaaq",
            "productCode": "5GH176411100",
            "purchaseOrder": null,
            "quantity": 1,
            "unit": "ST",
            "unitPrice": 1235.69
          },
          {
            "amount": 1098.24,
            "description": "ELEMENT ASSY, OIL CLEANER",
            "productCode": "5GH134408000",
            "purchaseOrder": null,
            "quantity": 16,
            "unit": "ST",
            "unitPrice": 114.4
          },
          {
            "amount": null,
            "description": "Ordre: 869924 Deres reference: PolarOilQaanaaq",
            "productCode": null,
            "purchaseOrder": null,
            "quantity": null,
            "unit": null,
            "unitPrice": null
          },
          {
            "amount": null,
            "description": null,
            "productCode": null,
            "purchaseOrder": null,
            "quantity": 1,
            "unit": "stk",
            "unitPrice": null
          }
        ],
        "vat": []
      }
    }
  }
}
