<template>
    <v-container>
        <v-data-table
            :headers="headers"
            :items="items"
            :items-per-page="20"
            class="elevation-1 bg"
            dark
        >
         <template v-slot:item.dayDefCnt="{ item }">
            <v-chip
                :color="getColor(item.dayDefCnt)"
                dark
            >
                {{ item.dayDefCnt | comma }}
            </v-chip>
        </template>

         <template v-slot:item.dayDeathCnt="{ item }">
            <v-chip
                :color="getColor2(item.dayDeathCnt)"
                dark
            >
                {{ item.dayDeathCnt | comma }}
            </v-chip>
        </template>
        
        </v-data-table>
    </v-container>
</template>
<script>
import axios from 'axios';
export default {
     name: 'GlobalList',
     
    data () {
      return {
        headers: [
          { text: '지역', value: 'nationName' },
          { text: '총 확진자', value: 'defCnt' },
          { text: '오늘 확진자', value: 'dayDefCnt' },
          { text: '총 사망자', value: 'deathCnt' },
          { text: '오늘 사망자', value: 'dayDeathCnt' },
        ],
        items: [],
      }
    },
    created() {
        axios
            .get('http://localhost:8000/covid19/global/today/countries')
            .then(({ data }) => {
                this.items = data;
            })
            .catch(() => {
                // console.log(error);
            });
    },
    filters:{
        comma(val){
            return String(val).replace(/\B(?=(\d{3})+(?!\d))/g, ",");
        }
    },
    methods: {
      getColor (dayDefCnt) {
        if (dayDefCnt > 100000) return 'red'
        else if (dayDefCnt > 10000) return 'orange'
        else return 'green'
      },
      getColor2 (dayDeathCnt) {
        if (dayDeathCnt > 1000) return 'red'
        else if (dayDeathCnt > 500) return 'orange'
        else return 'green'
      },
    },
}
</script>
<style scoped>
.bg{
    background-color: #001522;
}
</style>