<template>
    <div :class="['withdraw-container', {'dark-mode': isDarkMode}]">
        <ul class="card-list">
            <li class="card" v-for="(item,index) in items" :key="index">
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
                            <small>${{ item.monto }}</small>
                        </div>
                        <div>
                            <a>Estado</a>
                            <small :class="getEstadoClass(item.estado)">{{ item.estado }}</small>
                        </div>
                    </div>
                </div>
                <div class="card-actions">
                    <button>aprovado</button>
                    <button>rechazado</button>
                </div>
            </li>
        </ul>
    </div>
    
</template>

<script>
export default{
    name: 'WithdrawTab',
    props:{
        isDarkMode:{
            type: Boolean,
            required: true
        }
    },
    data(){
        return {
            items:[
                { user_id: 'Dleon', fecha: '2021-09-09', monto: 1000, estado: 'pendiente' },
                { user_id: 'Jlopez', fecha: '2021-09-10', monto: 500, estado: 'aprovado' },
                { user_id: 'Maria123', fecha: '2021-09-11', monto: 1200, estado: 'rechazado' },
                { user_id: 'UserX', fecha: '2021-09-12', monto: 200, estado: 'pendiente' },
                { user_id: 'Pedro45', fecha: '2021-09-13', monto: 800, estado: 'aprovado' },
            ]
        };
    },
    methods:{
        accept(item){
            console.log('aceptado', item);
        },
        reject(item){
            console.log('rechazado', item);
        },
        getEstadoClass(estado){
            switch (estado.toLowerCase()) {
                case 'pendiente':
                    return 'estado-pendiente';
                case 'aprovado':
                    return 'estado-aprovado';
                case 'rechazado':
                    return 'estado-rechazado';
                default:
                    return '';
            }
        }
    }

};
</script>
<style scoped>
.withdraw-container {
    padding: 20px;
    max-height: 100vh; /* Ajusta la altura máxima */
    overflow-y: auto;
    color: #2c3e50;
}
.card-list{
    list-style: none;
    padding: 0;
    margin: 0;
    display: flex;
    flex-direction: column;
    gap: 10px;
    overflow-y: auto; /* Habilita el scroll interno */
    max-height: 90vh;
}
.card{
    display: flex;
    justify-content: space-between;
    align-items: center;
    background-color: #fff;
    border: 1px solid #ccc;
    border-radius: 8px;
    padding: 10px;
    box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
}
.card.dark-mode{
    background-color: #2c3e50;
    color: #a0a7ac;
    border: 1px solid #444;
}
.card-content{
    display: flex;
    justify-content: space-between;
    width: 100%;
}

.card-info div,
.card-details div {
  display: flex;
  flex-direction: column; /* Cambiar a columna */
}
.card-details{
    display: flex;
    flex-direction: column;
    align-items: flex-end;
}
.card-actions{
    display: flex;
    flex-direction: column;
    gap: 5px;
}
button{
    padding: 5px 10px;
    border: none;
    border-radius: 4px;
    background-color: #1083D6;
    color: white;
    cursor: pointer;
    transition: background-color 0.3s;
    margin: 5px;
}
button:hover{
    background-color: #005bb5;
}
button:focus{
    outline: none;
}
/* Estilos para los estados */
.estado-pendiente {
    color: #f1c40f; /* Amarillo */
    font-weight: bold;
}

.estado-aprovado {
    color: #2ecc71; /* Verde */
    font-weight: bold;
}

.estado-rechazado {
    color: #e74c3c; /* Rojo */
    font-weight: bold;
}
</style>