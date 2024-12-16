
<template>
    <div :class="['contentPage',{'dark-mode': isDarkMode}]">
        <div :class="['CSV-page']">
            <h1>Upload CSV File</h1>
            <div class="file-upload-wrapper">
                <input type="file" @change="handleFileUpload" ref="fileInput" accept=".csv" />
                <button @click="triggerFileInput">Choose File</button>
                <span :class="[{'dark-mode':isDarkMode}]" v-if="selectedFile">{{ selectedFile.name }}</span>
                <span :class="[{'dark-mode':isDarkMode}]" v-else>No file selected</span>
            </div>
            
            <button @click="uploadFile" :disabled="!selectedFile">Upload File</button>
        </div>
    </div>
    
</template>
<script>
import Papa from 'papaparse';
    export default {
        name: 'CsvPage',
        props: {
            isDarkMode: {
                type: Boolean,
                required: true
            }
        },
        data(){
            return{
                selectedFile: null
            };
        },
        methods:{
            handleFileUpload(event){
                const file = event.target.files[0];
                if(file){
                    this.selectedFile = file;
                }
            },
            triggerFileInput(){
                this.$refs.fileInput.click();
            },
            async uploadFile(){
                if(!this.selectedFile){
                    alert('No file selected');
                    return;
                }
                const file = this.selectedFile;
                Papa.Parser(file,{
                    header: true,
                    complete: async (results) =>{
                        const jsonData = results.data;
                        console.log('Parsed JSON:',jsonData);
                        try{
                            const response = await fetch('http://localhost:3000/upload', {
                                method: 'POST',
                                headers: {
                                    'Content-Type': 'application/json'
                                },
                                body: JSON.stringify({data: jsonData})
                            });
                            if(!response.ok){
                                throw new Error('Error uploading file');
                            }
                            const result = await response.json();
                            alert('File uploaded successfully');
                            console.log(result);
                        }catch(error){
                            console.log(error);
                            alert('Error uploading file');
                        }
                    }
                });
            }
        }
    }
</script>
<style scoped>
.contentPage{
    width: 100%;
    height: 100vh;
    display: flex;
    justify-content: center;
    align-items: center;
    transition: background-color 0.3s;
}
.CSV-page {
    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: center;
    gap: 1rem;
    width: 50%;
    
}
.contentPage.dark-mode {
    background-color: #192229;
    color: #a0a7ac;
}
.contentPage:not(.dark-mode) {
    background-color: white;
    color: black;
}
.file-upload-wrapper {
    display: flex;
    gap: 1rem;
    align-items: center;
}
input[type="file"] {
    display: none;
}
button {
    padding: 0.5rem 1rem;
    background-color: #007BFF;
    color: white;
    border: none;
    border-radius: 0.25rem;
    cursor: pointer;
}
button:disabled {
    background-color: #6C757D;
    cursor: not-allowed;
}
span.dark-mode{
    font-size: 0.9rem;
    color: #a0a7ac;
}
span:not(.dark-mode){
    font-size: 0.9rem;
    color: #333;
}
</style>