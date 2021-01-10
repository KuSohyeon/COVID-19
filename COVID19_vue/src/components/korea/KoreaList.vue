<template>
  <v-container>
    <v-data-table
      :headers="headers"
      :items="today"
      :items-per-page="all"
      class="elevation-1 bg"
      dark
    >
      <template v-slot:item.dayDefCnt="{ item }">
        <v-chip :color="getColor(item.dayDefCnt)" dark>
          {{ item.dayDefCnt }}
        </v-chip>
      </template>
      <template v-slot:item.dayDeathCnt="{ item }">
        <v-chip :color="getColor(item.dayDeathCnt)" dark>
          {{ item.dayDeathCnt }}
        </v-chip>
      </template>
    </v-data-table>
  </v-container>
</template>

<script>
export default {
  name: 'KoreaList',
  data: function() {
    return {
      headers: [
        { text: '지역', value: 'sido' },
        { text: '총 확진자 수', value: 'totalDefCnt' },
        { text: '오늘 확진자 수', value: 'dayDefCnt' },
        { text: '총 사망자 수', value: 'totalDeathCnt' },
        { text: '오늘 사망자 수', value: 'dayDeathCnt' },
      ],
      today: [],
    };
  },
  created() {
    this.$axios
      .get('http://localhost:8000/covid19/korea/today')
      .then(({ data }) => {
        this.today = data;
      })
      .catch(() => {
        alert('에러가 발생했습니다.');
      });
  },
  methods: {
    getColor(cnt) {
      if (cnt > 300) return 'red';
      else if (cnt > 100) return 'orange';
      else return 'green';
    },
  },
};
</script>
<style scoped>
.bg {
  background-color: #001522;
}
</style>
