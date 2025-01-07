<template>
  <div class="card-container">
    <div class="card text-center" v-for="transaction in transactions" :key="transaction.transaction_id">
      <div class="card-header">
        <h5>Transaction Details</h5>
      </div>
      <div class="card-body">
        <div class="row">
          <div class="col">
            <h5>Transaction ID: {{ transaction.transaction_id }}</h5>
            <p><strong>Type:</strong> {{ transaction.transaction_type_id }}</p>
            <p><strong>Date:</strong> {{ transaction.transaction_date }}</p>
          </div>
          <div class="col">
            <p><strong>Created By:</strong> {{ transaction.transaction_created_by_username }} <button type="button" class="btn btn-info p-2 rounded-circle">info</button></p>
            <p><strong>Amount:</strong> ${{ transaction.transaction_amount }}</p>
            <p><strong>Is Finalized:</strong> {{ transaction.is_finalized ? 'Yes' : 'No' }}</p>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>
<script>
  import Papa from 'papaparse';
export default{

  name: 'DepositTab',
  data(){
    return{
      transactions:[],
    }
  },
  mounted(){
    const UrlCsv = "/test_deposit.csv";
    Papa.parse(UrlCsv, {
      download: true,
      header: true,
      complete: (result) => {
        this.transactions = result.data;
      },
      error: (error) => {
        console.error(error);
      }
    });

  }
}
</script>

<style scoped>
.card-container {
  max-height: 70vh; /* Ajusta esta altura según tus necesidades */
  overflow-y: auto;
}
</style>