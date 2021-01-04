<template>
    <v-container>
        <v-row class="justify-center">
            <v-card
            class="pa-2 text-center card"
            sm="4"
            color="#001522"
            elevation="0"
            dark
            >
            총 확진자<br><br>
            <h2>{{this.data.defCnt | comma}}</h2> 명<br><br>
            <div class="text-center">
                <span class="white--text dayCnt">
                      <v-icon
                    midium
                    color="red"
                    >
                    mdi-arrow-up
                    </v-icon>
                    {{this.data.dayDefCnt | comma}}
                </span>
            </div>
            </v-card>
            <v-card
            class="pa-2 text-center card"
            sm="4"
            color="#001522"
            elevation="0"
            dark>
                총 사망자<br><br>
                 <h2>{{this.data.deathCnt | comma}}</h2> 명<br><br>
                  <div class="text-center">
                    <span class="white--text dayCnt">
                         <v-icon
                        midium
                        color="red"
                        >
                        mdi-arrow-up
                        </v-icon>
                        {{this.data.dayDeathCnt | comma}}
                    </span>
                </div>
            </v-card>
        </v-row>
    </v-container>
</template>
<script>
import axios from 'axios';
export default {
    name: 'GlobalToday',
    data() {
        return {
            data: {},
        }
    },
    created() {
        axios
            .get('http://localhost:8000/covid19/global/today/total')
            .then(({data})=>{
                this.data = data;
            })  
            .catch(()=>{

            });
    },
    filters:{
    comma(val){
        return String(val).replace(/\B(?=(\d{3})+(?!\d))/g, ",");
    }
    },
}
</script>
<style scoped>
.card{
    margin: 10px;
    min-width: 400px;
    min-height: 200px;
}
h2{
    display: inline;
}
.dayCnt{
    padding: 5px;
    background-color: #790000;
    color: #EF5350;
    opacity: 0.6;
    border-radius: 5px;
}
</style>