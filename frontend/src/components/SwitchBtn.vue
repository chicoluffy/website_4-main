<template>
    <label class="switch">
      <input type="checkbox" @click="toggleDarkMode" :checked="isDarkMode"/>
      <span class="slider"></span>
    </label>
</template>

<script>
import EventBus from '@/eventBus/eventBus';
export default{
    name: 'SwitchBtn',
    props: {
        isDarkMode:{
            type: Boolean,
            required: true
        }
    },
    methods:{
        toggleDarkMode(){
            const newMode = !this.isDarkMode;
            localStorage.setItem('dark-mode', newMode);
            EventBus.emit('toggle-dark-mode', newMode);
        }
    }
}
</script>
<style scoped>
     /*comienza el switch para cambiar de color */ 
  .switch {
  font-size: 17px;
  position: absolute;
  display: inline-block;
  width: 3.5em;
  height: 2em;
  top : 1.3em;
  right: 1.3em;
}
.switch input {
  opacity: 0;
  width: 0;
  height: 0;
}
.slider {
  position: absolute;
  cursor: pointer;
  inset: 0;
  background: black;
  border-radius: 50px;
  transition: all 0.4s cubic-bezier(0.175, 0.885, 0.32, 1.275);
}
.slider:before {
  position: absolute;
  content: "";
  display: flex;
  align-items: center;
  justify-content: center;
  height: 2em;
  width: 2em;
  inset: 0;
  background-color: white;
  border-radius: 50px;
  box-shadow: 0 10px 20px rgba(0, 0, 0, 0.4);
  transition: all 0.4s cubic-bezier(0.175, 0.885, 0.32, 1.275);
}
.switch input:checked + .slider {
  background: lime;
}
.switch input:focus + .slider {
  box-shadow: 0 0 1px #0974f1;
}

.switch input:checked + .slider:before {
  transform: translateX(1.6em);
}
/*termina el switch para cambiar de color */
</style>