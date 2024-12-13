<template>
    <div :class="['content-Page',{'dark-mode': isDarkMode}]">
        <div class="single-deposit-container">
            <h2>Single Deposit</h2>
            <from @submit.prevent="handleDeposit">
                <div class="form-group">
                    <label for="depositAmount">Amount to deposit</label>
                    <input
                        type="number"
                        v-model="depositAmount"
                        class="form-control"
                        placeholder="Enter amount to deposit"
                        required
                    />
                </div>
                <div class="form-group">
                    <label for="bankCompany">Bank Company</label>
                    <select
                    id="bankCompany"
                    v-model="selectedBank"
                    class="form-control"
                    required>  
                    <option disabled value="">Select a Bank Company</option>
                    <option v-for="bank in backCompanies" :key="bank.id" :value="bank.id">{{ bank.name }}</option>
                    </select>
                </div>
                <div class="form-group">
                    <label for="customerId">Id of Customer</label>
                    <input
                    type="text"
                    id="customerId"
                    v-model="customerId"
                    class="form-control"
                    placeholder="Enter the customer ID"
                    required/>
                </div>
                <button type="submit" class="form-control submit-button">Deposit</button>
            </from>
        </div>
    </div>
</template>
<script>
export default {
  name: 'SingleDeposit',
  props:{
    isDarkMode:{
      type:Boolean,
      required:true
    }
  },
  data(){
    return{
        depositAmount: '',
        selectedBank: '',
        customerId: '',
        backCompanies: [
            {id: 1, name: 'Bank of America'},
            {id: 2, name: 'Chase'},
            {id: 3, name: 'Wells Fargo'},
            {id: 4, name: 'Citi Bank'},
            {id: 5, name: 'US Bank'},
        ]
    };
  },
  methods:{
    handleDeposit(){
        alert(`deposit amount: ${this.depositAmount}, bank: ${this.selectedBank}, customer ID: ${this.customerId}`);
    }
  }
}
</script>
<style scoped>
.content-Page {
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  gap: 1rem;
  width: 100%;
  height: 100vh;
  transition: background-color 0.3s;
}

.single-deposit-container {
  display: flex;
  flex-direction: column;
  gap: 1.5rem; /* Espacio entre los elementos del formulario */
  width: 80%; /* Ajusta el ancho del contenedor */
  max-width: 37.5rem; /* Ancho máximo del contenedor */
  padding: 2rem; /* Espacio interno del contenedor */
  background-color: #fff;
  border-radius: 8px;
  box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
}

.single-deposit-container label {
  font-size: 1rem;
  color: #333;
}
.form-group {
  display: flex;
  flex-direction: column;
  gap: 0.5rem;
  width: 100%;
}

.form-control {
  width: 100%;
  padding: 0.75rem;
  font-size: 1rem;
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;
  transition: border-color 0.3s;
}

.form-control:focus {
  border-color: #007bff;
  outline: none;
}

button.form-control {
  background-color: #007bff;
  color: white;
  border: none;
  cursor: pointer;
}
button.submit-button {
  margin-top: 1rem; /* Espacio adicional encima del botón */
  padding: 1rem; /* Aumenta el tamaño del botón */
  font-size: 1.25rem; /* Aumenta el tamaño del texto del botón */
}

button.form-control:hover {
  background-color: #0056b3;
}

.content-Page.dark-mode {
  background-color: #192229;
  color: #52A5E0;
}

.content-Page.dark-mode .single-deposit-container {
  background-color: #2a3b47;
}

.content-Page.dark-mode .form-control {
  background-color: #2a3b47;
  color: #52A5E0;
  border: 1px solid #52A5E0;
}

.content-Page.dark-mode .form-control:focus {
  border-color: #52A5E0;
}

.content-Page.dark-mode button.form-control {
  background-color: #52A5E0;
  color: #192229;
}

.content-Page.dark-mode button.form-control:hover {
  background-color: #3a4b57;
}
.content-Page.dark-mode label {
  color: #52A5E0;
}
</style>