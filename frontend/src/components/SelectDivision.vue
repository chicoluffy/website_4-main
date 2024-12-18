<template>
    <div :class="['select-container',{ 'dark-mode': isDarkMode }]" >
        <label for="icon-select" class="select-label">Select a countrie:</label>
        <div class="select-wrapper">
            <select class="styled-select" :class="{'dark-mode': isDarkMode}" v-model="selectedOption" @change="onSelectChange">
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
                    {value: "DivisionCastleBetCongo",label: "Division Congo"},
                    {value: "DivisionGambia",label: "Division Gambia"},
                    {value: "DivisionGhana",label: "Division Ghana"},
                    {value: "DivisionKenya",label: "Division Kenya"},
                    {value: "DivisionLesotho",label: "Division Lesotho"},
                    {value: "DivisionMalawi",label: "Division Malawi"},
                    {value: "DivisionCastleBetNamibia", label: "Division Namibia"},
                    {value: "DivisionUganda", label: "Division Uganda"},
                    {value: "DivisionCastleBet", label: "Division Zambia"},
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
.styled-select {
    width: 100%;
  padding: 10px;
  font-size: 16px;
  border: 1px solid #ccc;
  border-radius: 4px;
  background-color: white;
  color: #333;
  appearance: none; /* Elimina el estilo por defecto del navegador */
  -webkit-appearance: none; /* Elimina el estilo por defecto del navegador en Safari */
  -moz-appearance: none; /* Elimina el estilo por defecto del navegador en Firefox */
  background-repeat: no-repeat;
  background-position: right 10px center;
  background-size: 16px 16px;
}
.styled-select.dark-mode {
  background-color: #2a3b47;
  color: #52A5E0;
  border: 1px solid #52A5E0;
}
.styled-select:focus.dark-mode{
    border-color: #192229;
    outline: none;
}
.styled-select:not(.dark-mode) {
    width: 100%;
    padding: 0.6rem;
    font-size: 0.9rem;
    border: 1px solid #ccc;
    border-radius: 0.2rem;
    background-color: white;
    color : #333;
    appearance: none;/* Elimina el estilo por defecto del navegador */
    -webkit-appearance: none; /* Elimina el estilo por defecto del navegador en Safari */
    -moz-appearance: none;/* Elimina el estilo por defecto del navegador en Firefox */
    background-repeat: no-repeat;
    background-position: right 0.6rem center;
    background-size: 0.9rem 0.9rem;
}
.styled-select:focus:not(.dark-mode){
    border-color: #007bff;
    outline: none;
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
</style>