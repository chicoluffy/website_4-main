<template>
    <div class="modal-overlay" v-if="visible">
        <div class="modal">
            <div class="modal-header">
                <h3>{{ title }}</h3>
                <button @click="closeModal" class="close-button">&times;</button>
            </div>
            <div class="modal-body">
                <p>{{ message }}</p>
            </div>
            <div class="modal-footer">
                <button @click="closeModal">Close</button>
            </div>
        </div>
    </div>
</template>

<script>
export default {
    name: 'ModalComponent',
    props: {
        title: {
            type: String,
            required: true
        },
        message: {
            type: String,
            required: true
        },
        visible: {
            type: Boolean,
            required: true
        },
    },
    methods: {
        closeModal() {
            this.$emit('close');
        }
    }
};
</script>
<style scoped>
.modal-overlay{
    position: fixed;
    top: 0;
    left: 0;
    width: 100%;
    height: 100%;
    background-color: rgba(0, 0, 0, 0.5);
    display: flex;
    justify-content: center;
    align-items: center;
}
.modal{
    background: white;
    padding: 20px;
    border-radius: 8px;
    width: 300px;
    max-width: 100%;

}
.model-header{
    display: flex;
    justify-content: space-between;
    align-items: center;
}
.close-button{
    background: none;
    border: none;
    font-size: 1.5rem;
    cursor: pointer;
}
.modal-body{
    margin: 20px 0;
}
.modal-footer{
    display: flex;
    justify-content: flex-end;
}
</style>