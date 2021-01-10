<template>
  <v-container>
    <v-row class="justify-center">
      <v-col cols="6" md="4">
        <p class="white--text">총 확진자 수</p>
        <div v-for="t in total" :key="t.sido">
          <div v-if="t.sido == '합계'">
            <a class="white--text">{{ t.totalDefCnt }}명 </a>
            <a class="updateDef">
              <v-icon midium color="red">
                mdi-arrow-up
              </v-icon>
              {{ t.dayDefCnt }}
            </a>
          </div>
        </div>
      </v-col>
      <v-col cols="6" md="4">
        <p class="white--text">총 사망자 수</p>
        <div v-for="t in total" :key="t.sido">
          <div v-if="t.sido == '합계'">
            <a class="white--text">{{ t.totalDeathCnt }}명 </a>
            <a class="updateDef">
              <v-icon midium color="red">
                mdi-arrow-up
              </v-icon>
              {{ t.dayDeathCnt }}
            </a>
          </div>
        </div>
      </v-col>
    </v-row>
  </v-container>
</template>

<script>
export default {
  name: 'KoreaTotal',
  data: function() {
    return {
      total: {},
    };
  },
  created() {
    this.$axios
      .get('http://localhost:8000/covid19/korea/total')
      .then(({ data }) => {
        this.total = data;
      })
      .catch(() => {
        alert('에러가 발생했습니다.');
      });
  },
};
</script>
<style scoped>
.updateDef {
  padding: 5px;
  background-color: #790000;
  color: #ef5350;
  opacity: 0.6;
  border-radius: 5px;
}
</style>
