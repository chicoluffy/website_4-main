<template>
    <div :class="['withdraw-page', {'dark-mode': isDarkMode}]">
        <div class="balance-header">
            <h2>Withdraw balance</h2>
            <div>
                <strong>playable founds:</strong>
                <span>${{ balance.playableFunds }}</span>
            </div>
            <div>
                <strong>Pending Amount</strong>
                <span>${{ balance.pendingAmount }}</span>
            </div>
            <button class="payout-button" @click="payoutNow">Payout Now</button>
        </div>
    </div>
    <div class="filters">
        <input type="text" v-model="filters.customersID" placeholder="Customer ID"/>
        <input type="text" v-model="filters.invoiceRef" placeholder="Invoice Ref"/>
        <button @click="applyFilters">Apply</button>
        <button @click="resetFilters">ResetFilters</button>
    </div>
    <table class="transaction-table">
        <thead>
            <tr>
                <th>Sales Invoice</th>
                <th>Customer</th>
                <th>Method</th>
                <th>Charged</th>
                <th>Fee</th>
                <th>Net</th>
                <th>Charged on</th>
            </tr>
        </thead>
        <tbody>
            <tr v-for="(transaction, index) in transaction" :key="index">
                <td>{{ transaction.invoice }}</td>
                <td>{{ transaction.customer }}</td>
                <td>{{ transaction.method }}</td>
                <td>£ {{ transaction.charged }}</td>
                <td>£ {{ transaction.fee }}</td>
                <td>£ {{ transaction.net }}</td>
                <td>{{ transaction.date }}</td>
            </tr>
        </tbody>
    </table>
    <div class="pagination">
        <button @click="changePage(currentPage - 1)" :disabled="currentPage === 1">Previous</button>
        <span>Page {{ currentPage }} of {{ totalPages }}</span>
        <button @click="changePage(currentPage + 1)" :disabled="currentPage === totalPages">Next</button>
    </div>
</template>

<script>
export default{
    name: 'DepositTab',
    props:{
        isDarkMode:{
            type:Boolean,
            required:true
        }
    },
    data(){
        return{
            balance: {
                playableFunds: 1000.0,
                pendingAmount: 299.8
            },
            filters: {
                customersID: '',
                invoiceRef: ''
            },
            currentPage: 1,
            rowPerPage: 5,
            transaction:[
            {
                invoice: "INV-123456129",
                customer: "alice.schmidt@unipas.com",
                method: "****1234",
                charged: 300.0,
                fee: -0.2,
                net: 299.8,
                date: "12/08/2022",
                },
                {
                invoice: "INV-123456128",
                customer: "alice.schmidt@unipas.com",
                method: "****1234",
                charged: 200.0,
                fee: 0.0,
                net: 199.8,
                date: "10/08/2022",
                },
                {
                invoice: "INV-123456127",
                customer: "alice.schmidt@unipas.com",
                method: "****1234",
                charged: 100.0,
                fee: -0.2,
                net: 99.8,
                date: "07/08/2022",
                },
            ],
        };
    },
    computed: {
        totalPages(){
            return Math.ceil(this.transaction.length / this.rowPerPage);
        },
        filteredTransactions(){
            let filtered = this.transaction;
            if(this.filters.customersID){
                filtered = filtered.filter(transaction => transaction.customer.includes(this.filters.customersID));
            }
            if(this.filters.invoiceRef){
                filtered = filtered.filter(transaction => transaction.invoice.includes(this.filters.invoiceRef));
            }
            const start = (this.currentPage - 1) * this.rowPerPage;
            return filtered.slice(start, start + this.rowPerPage);
        },
    },
    methods:{
        applyFilters(){
            this.currentPage = 1;
        },
        resetFilters(){
            this.filters.customersID = '';
            this.filters.invoiceRef = '';
            this.currentPage = 1;
        },
        playoutNow(){
            alert('Payout Now');
        },
        changePage(page){
           if(page>1 && page <= this.totalPages){
               this.currentPage = page;
           }
        }
    }
}
</script>

<style scoped>
.withdraw-page {
  font-family: Arial, sans-serif;
  margin: 20px;
}

.balance-header {
  display: flex;
  justify-content: space-between;
  align-items: center;
  padding: 10px;
  background-color: #007bff;
  color: white;
  border-radius: 8px;
}

.payout-button {
  padding: 8px 12px;
  background-color: white;
  color: #007bff;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}

.filters {
  margin: 20px 0;
}

.filters input {
  margin-right: 10px;
  padding: 5px;
}

.transaction-table {
  width: 100%;
  border-collapse: collapse;
}

.transaction-table th,
.transaction-table td {
  border: 1px solid #ddd;
  padding: 8px;
  text-align: left;
}

.transaction-table th {
  background-color: #f2f2f2;
  color: #333;
}

.transaction-table tr:nth-child(even) {
  background-color: #3a4b57;
}

.transaction-table tr:hover {
  background-color: #3a4b57;
}

.withdraw-page.dark-mode .transaction-table {
  border-color: #444;
}

.withdraw-page.dark-mode .transaction-table th {
  background-color: #2a3b47;
  color: #fff;
}

.withdraw-page.dark-mode .transaction-table td {
  background-color: #1f2a33;
  color: #fff;
}

.withdraw-page.dark-mode .transaction-table tr:nth-child(even) {
  background-color: #2a3b47;
}

.withdraw-page.dark-mode .transaction-table tr:hover {
  background-color: #3a4b57;
}
.pagination {
  display: flex;
  justify-content: center;
  margin-top: 10px;
}

.pagination button {
  margin: 0 5px;
  padding: 5px 10px;
}
</style>