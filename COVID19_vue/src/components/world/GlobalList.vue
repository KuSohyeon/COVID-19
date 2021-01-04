<template>
    <v-container>
        <v-data-table
            :headers="headers"
            :items="desserts"
            :items-per-page="5"
            class="elevation-1"
        ></v-data-table>
    </v-container>
</template>
<script>
import axios from 'axios';
export default {
     name: 'GlobalList',
    data () {
      return {
        headers: [
          { text: '지역', value: 'nation' },
          { text: '총 확진자', value: 'defCnt' },
          { text: '오늘 확진자', value: 'dayDefCnt' },
          { text: '총 사망자', value: 'DeathCnt' },
          { text: '오늘 사망자', value: 'dayDeathCnt' },
        ],
        items: [],
      }
    },
    created() {
        axios
            .get('http://localhost:8000/covid/global/today/countries')
            .then(({ data }) => {
                this.items = data;
            })
            .catch(() => {
                // console.log(error);
            });
    }
  
}
</script>
<style scoped>
</style>