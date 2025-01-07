<template>
    <div :class="['select-container',{ 'dark-mode': isDarkMode }]" >
        <label for="icon-select" class="select-label">Select a countrie:</label>
        <div class="select-wrapper">
            <select class="form-select" :class="{'dark-mode': isDarkMode}" v-model="selectedOption" @change="onSelectChange">
                <option disabled value="">Please select one</option>
                <option v-for="option in options" :key="option.value" :value="option.value">
                 {{ option.label }}
                </option>
            </select>
            <div class="custom-select">
                <button :disabled="!selectedOption" @click="goToHomePage">Go to Home Page</button>
            </div>
        </div>
    </div>
</template>
<script>
    export default {
        name: 'SelectDivision',
        components: {
        },
        props: {
            isDarkMode: {
                type: Boolean,
                required: true
            }
        },
        data(){
            return{
                selectedOption: "",
                options:[
                    {value: "DivisionMalawi",label: "Division Malawi"},
                ]
            }
        },
        methods:{
            onSelectedLabel(){
                const selected = this.options.find(option => option.value === this.selectedOption);
                return selected ? `${selected.icon} ${selected.label}` : '';
            },
            goToHomePage(){
                this.$router.push('/home');
            }
        }
    };
</script>
<style scoped>
.select-container {
    display: flex;
    flex-direction: column;
    gap: 0.5rem;
    width: 100%; /* Asegura que ocupe todo el ancho */
    max-width: 500px; /* Si quieres limitar el ancho */
    margin: 0 auto; /* Centrar en pantalla */
    transition: background-color 0.3s;
}
.select-container.dark-mode {
    background-color: #192229;
    color: #52A5E0;
}
.select-container:not(.dark-mode) {
    background-color: #FBFBFE;
    color: #2A3B47;
}

.select-label {
    font-size: 16px;
    color: #333;
    text-align: center;
}
.select-container.dark-mode .select-label {
  color: #52A5E0; /* Cambia el color del label en modo oscuro */
}
.select-wrapper {
    position: relative;
    width: 100%;
}
.icon {
  font-size: 18px;
}

.label {
  font-size: 16px;
  color: #333;
}
button {
  margin-top: 1rem;
  padding: 0.5rem 1rem;
  font-size: 16px;
  color: white;
  background-color: #007bff;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}

button:disabled {
  background-color: #ccc;
  cursor: not-allowed;
}
/* Estilos para pantallas pequeñas */

</style>