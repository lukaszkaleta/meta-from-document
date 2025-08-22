import {LitElement, html, css} from 'lit'
import { repeat } from 'lit/directives/repeat.js'
import '@shoelace-style/shoelace/dist/components/card/card.js'
import '@shoelace-style/shoelace/dist/components/alert/alert.js'
import '@shoelace-style/shoelace/dist/components/icon/icon.js'
import '@shoelace-style/shoelace/dist/components/button/button.js'
import '@shoelace-style/shoelace/dist/components/tooltip/tooltip.js'
import '@shoelace-style/shoelace/dist/components/tag/tag.js'
import '@shoelace-style/shoelace/dist/components/details/details.js'

export class ReceiptCard extends LitElement {
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
    receipt: { type: Object }
  }

  firstUpdated(changedProperties) {
    super.firstUpdated(changedProperties)
  }

  renderLineItem(lineItem) {
      return html`<row>
          <inline>${lineItem.description}</inline>
          <inline>${lineItem.quantity}</inline>
          <inline>${lineItem.amount}</inline>
        </row>`
  }

  renderLineItems() {
    return html`
        <sl-details summary="Details" class="custom-icons">
            <column>
                ${repeat(this.receipt.lineItem, lineItem => lineItem, lineItem => this.renderLineItem(lineItem))}
            </column>
        </sl-details>
    `

  }

  renderSummary() {
    return html`
        <row>
            <inline>
                <label>receiptDate</label>
            </inline>
            <inline>${this.receipt.receiptDate}</inline>
        </row>
        <row>
            <inline>
                <label>supplierPhone</label>
            </inline>
            <inline>${this.receipt.supplierPhone}</inline>
        </row>
        <row>
            <inline>
                <label>totalAmount</label>
            </inline>
            <inline>${this.receipt.totalAmount}</inline>
        </row>
    `
  }

  render() {
    return html`
        <sl-card>
            <row slot="header">${this.receipt.supplierName}</row>
            <column>
              ${this.renderSummary()}
              ${this.renderLineItems()}
            </column>
        </sl-card>
        
    `
  }
}
customElements.define('hvd-receipt-card', ReceiptCard)
