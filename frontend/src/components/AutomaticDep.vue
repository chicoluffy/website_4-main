<!--si supieras que aun te extraño-->
<template>
  <div :class="['DepWithPage', {'dark-mode': isDarkMode}]">
    <h1>Automatic Deposit</h1>
    <ul class="card-list">
      <li class="card" v-for="(item, index) in visibleItems" :key="index" :class="{'dark-mode': isDarkMode}">
        <div class="card-content">
          <!-- Información de la tarjeta -->
          <div class="card-info">
            <div>
              <a>User_id</a>
              <small>{{ item.user_id }}</small>
            </div>
            <div>
              <a>Fecha</a>
              <small>{{ item.fecha }}</small>
            </div>
          </div>
          <div class="card-details">
            <div>
              <a>Monto</a>
              <small>${{ item.monto }}</small>
            </div>
            <div>
              <a>Estado</a>
              <small :class="{'status-pending': item.estado === 'pendiente', 'status-approved': item.estado === 'aprovado', 'status-rejected': item.estado === 'rechazado', 'dark-mode': isDarkMode}">
                {{ item.estado }}
              </small>
            </div>
          </div>
          <!-- Botón circular -->
          <div>
            <button :class="['circle-button', {'dark-mode': isDarkMode}]" @click="viewDetails(item)">
              <i class="fas fa-info"></i>
            </button>
          </div>
        </div>
      </li>
    </ul>
  </div>
</template>

<script>
export default {
    name: 'AutomaticDepositPage',
    props: {
        isDarkMode: {
            type: Boolean,
            required:true
        }
    },
    data(){
        return{
            items:[],
            visibleItems:[]
        };
    },
    mounted(){
        fetch('/test_withdraw_data.json')
        .then(response => response.json())
        .then(data => {
            this.items = data;
            this.showItemsOneByOne();
        })
        .catch(error => console.error(error));
    },
    methods:{
      viewDetails(item){
        alert(`See more information about: ${item.user_id}`);
      },
        //eliminar este metodo y cambiar por un websocket
        showItemsOneByOne(){
            this.items.forEach((item, index)=>{
                setTimeout(()=>{
                    this.visibleItems.push(item);
                }, index * 1000);
            })
            //reiniciar los elementos cuando se acabe el ciclo
            setTimeout(()=>{
                this.visibleItems = [];
                this.showItemsOneByOne();
            }, this.items.length * 1000);
        }
    }
}
</script>


<style scoped>
.DepWithPage {
  padding: 20px;
  max-height: 100vh; /* Ajusta la altura máxima */
  overflow-y: auto; /* Agrega scroll vertical */
  width: 95%;
}

.card-list {
  list-style-type: none;
  padding: 0;
}

.card {
  display: flex;
  justify-content: space-between;
  align-items: center;
  background-color: #fff;
  border: 1px solid #ccc;
  border-radius: 8px;
  padding: 15px;
  margin-bottom: 15px;
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
  position: relative;
}

.card.dark-mode {
  background-color: #2c3e50;
  color: #a0a7ac;
  border: 1px solid #444;
}

.card-content {
  display: flex;
  justify-content: space-between;
  width: 100%;
}

.card-info div,
.card-details div {
  display: flex;
  flex-direction: column; /* Cambiar a columna */
}

.card-details {
  display: flex;
  flex-direction: column;
  align-items: flex-end;
}
.circle-button{
  position: absolute;
  top: 50%;
  right: 10px;
  transform: translateY(-50%);
  background-color: #007bff;
  color: #fff;
  border: none;
  border-radius: 50%;
  width: 40px;
  height: 40px;
  display: flex;
  justify-content: center;
  align-items: center;
  cursor: pointer;
  transition: background-color 0.3s ease;
  margin-left: 5px; 
}
.circle-button:hover{
  background-color: #0056b3;
}
.circle-button i{
  font-size: 16px;
}
.status-pending{
  color: orange;
}
.status-approved{
  color: green;
}
.status-rejected{
  color: red;
}
/*Modo oscuro*/
.DepWithPage.dark-mode {
  background-color: #121212;
  color: #e0e0e0;
}
.card.card.dark-mode{
  background-color: #1e1e1e;
  color: #e0e0e0;
  border: 1px solid #333;
}
.circle-button.dark-mode{
  background-color: #333;
  color: #e0e0e0;
}
.circle-button.dark-mode:hover{
  background-color: #555;
}
.status-pending.dark-mode {
  color: #ff9800;
}

.status-approved.dark-mode {
  color: #4caf50;
}

.status-rejected.dark-mode {
  color: #f44336;
}


</style>