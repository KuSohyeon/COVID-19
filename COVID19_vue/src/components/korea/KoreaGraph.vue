<script>
import { Line } from 'vue-chartjs';
export default {
  name: 'KoreaGraph',
  extends: Line,
  data() {
    return {
      week: [],
      datacollection: {
        //Data to be represented on x-axis
        labels: [],
        datasets: [
          {
            label: '일별 확진자 수',
            backgroundColor: '#001522',
            borderColor: [
              'rgba(255, 99, 132, 1)',
              'rgba(54, 162, 235, 1)',
              'rgba(255, 206, 86, 1)',
              'rgba(75, 192, 192, 1)',
              'rgba(153, 102, 255, 1)',
              'rgba(255, 159, 64, 1)',
              'rgba(255, 102, 0, 1)',
            ],
            borderWidth: 2,
            //Data to be represented on y-axis
            data: [],
          },
        ],
      },
      //Chart.js options that controls the appearance of the chart
      options: {
        scales: {
          yAxes: [
            {
              ticks: {
                beginAtZero: false,
              },
              gridLines: {
                display: true,
              },
            },
          ],
          xAxes: [
            {
              gridLines: {
                display: false,
              },
            },
          ],
        },
        legend: {
          display: true,
        },
        responsive: true,
        maintainAspectRatio: false,
      },
    };
  },
  mounted() {
    this.$axios
      .get('http://localhost:8000/covid19/korea/week')
      .then(({ data }) => {
        this.week = data;
        for (var i = 0; i < this.week.length; i++) {
          this.datacollection.labels[i] = this.week[i].stdDay;
          this.datacollection.datasets[0].data[i] = this.week[i].dayDefCnt;
        }
        this.renderChart(this.datacollection, this.options);
      })
      .catch(() => {
        alert('에러가 발생했습니다.');
      });
  },
};
</script>
