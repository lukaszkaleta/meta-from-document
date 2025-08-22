import {LitElement, html, css} from 'lit'
import { repeat } from 'lit/directives/repeat.js'
import '@shoelace-style/shoelace/dist/components/card/card.js'
import '@shoelace-style/shoelace/dist/components/alert/alert.js'
import '@shoelace-style/shoelace/dist/components/icon/icon.js'
import '@shoelace-style/shoelace/dist/components/button/button.js'
import '@shoelace-style/shoelace/dist/components/tooltip/tooltip.js'
import '@shoelace-style/shoelace/dist/components/tag/tag.js'
import '@shoelace-style/shoelace/dist/components/details/details.js'

export class ControlCard extends LitElement {
  static styles = [css`
      :host {
          display: block;
          width: 100%;
      }
      sl-card {
          width: 100%;
      }
      sl-card {
          box-shadow:
                  3px 3px 15px 1px rgba(66, 68, 90, 0.1),
                  3px 3px 10px 1px rgba(0, 0, 0, 0.05);
          width: 100%;
          border-radius: var(--sl-border-radius-medium);
      }
      sl-card::part(header) {
          background-color: var(--sl-color-neutral-100);
          padding: var(--sl-spacing-small);
          font-weight: bold;
      }
      sl-card::part(body) {
          margin: var(--sl-spacing-small);
          padding: 0;
      }
      column {
          display: flex;
          flex-direction: column;
          gap: var(--sl-spacing-x-small);
      }

      row {
          display: flex;
          flex-direction: row;
          gap: var(--sl-spacing-x-small);
      }
      row inline {
          flex: 1;
      }
      label {
          font-weight: bold;
          text-transform: capitalize;
      }
  `]

  static properties = {
    invoice: { type: Object }
  }

  firstUpdated(changedProperties) {
    super.firstUpdated(changedProperties)
  }

  renderLineItem(lineItem) {
    if(lineItem.unitPrice) {
      return html`<row>
          <inline>${lineItem.productCode}</inline>
          <inline>${lineItem.description}</inline>
          <inline>${lineItem.quantity}</inline>
          <inline>${lineItem.unit}</inline>
          <inline>${lineItem.unitPrice}</inline>
        </row>`
    }
  }

  renderLineItems() {
    return html`
        <sl-details summary="Details" class="custom-icons">
            <column>
                ${repeat(this.invoice.lineItem, lineItem => lineItem, lineItem => this.renderLineItem(lineItem))}
            </column>
        </sl-details>
    `

  }

  renderSummary() {
    return html`
        <row>
            <inline>
                <label>invoiceDate</label>
            </inline>
            <inline>${this.invoice.invoiceDate}</inline>
        </row>
        <row>
            <inline>
                <label>supplierName</label>
            </inline>
            <inline>${this.invoice.supplierName}</inline>
        </row>
        <row>
            <inline>
                <label>supplierPhone</label>
            </inline>
            <inline>${this.invoice.supplierPhone}</inline>
        </row>
        <row>
            <inline>
                <label>receiverName</label>
            </inline>
            <inline>${this.invoice.receiverName}</inline>
        </row>
        <row>
            <inline>
                <label>receiverAddress</label>
            </inline>
            <inline>${this.invoice.receiverAddress}</inline>
        </row>
        <row>
            <inline>
                <label>shipToName</label>
            </inline>
            <inline>${this.invoice.shipToName}</inline>
        </row>
        <row>
            <inline>
                <label>totalAmount</label>
            </inline>
            <inline>${this.invoice.totalAmount}</inline>
        </row>
        <row>
            <inline>
                <label>currency</label>
            </inline>
            <inline>${this.invoice.currency}</inline>
        </row>
    `
  }

  render() {
    return html`
<!--        <pre>${JSON.stringify(this.invoice, undefined, 2)}</pre>-->
        <sl-card>
            <row slot="header">Invoice #${this.invoice.invoiceId}</row>
            <column>
              ${this.renderSummary()}
              ${this.renderLineItems()}
            </column>
        </sl-card>
        
    `
  }
}
customElements.define('hvd-invoice-card', ControlCard)
