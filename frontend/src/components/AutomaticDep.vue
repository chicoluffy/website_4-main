<!--si supieras que aun te extraño-->
<template>
    <div :class="['DepWithPage', {'dark-mode': isDarkMode}]">
    <h1>Automatic Deposit</h1>
    <ul class="card-list">
      <li class="card" v-for="(item, index) in visibleItems" :key="index">
        <div class="card-content">
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
              <small>{{ item.monto }}</small>
            </div>
            <div>
              <a>Estado</a>
              <small>{{ item.estado }}</small>
            </div>
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
            default: false
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
  padding: 10px;
  margin-bottom: 10px;
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


</style>