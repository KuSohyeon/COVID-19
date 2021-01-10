<script>
import axios from 'axios';
  //Importing Line class from the vue-chartjs wrapper
  import {Line} from 'vue-chartjs'
  //Exporting this so it can be used in other components
  export default { 
    extends: Line,
    data () {
      return {
        items: [],
        datacollection: {
          //Data to be represented on x-axis
          labels: [],
          datasets: [
            {
              label: '추가 확진자',
                 backgroundColor: [
						'rgba(0, 0, 0, 0)'
				],
				borderColor: [
						'rgba(255, 99, 132, 1)',
						'rgba(54, 162, 235, 1)',
						'rgba(255, 206, 86, 1)',
						'rgba(75, 192, 192, 1)',
						'rgba(153, 102, 255, 1)',
						'rgba(255, 159, 64, 1)',
            'rgba(255, 102, 0, 1)'
				],
				borderWidth: 2,
              //Data to be represented on y-axis
              data: [],
            }
          ]
        },
     
        //Chart.js options that controls the appearance of the chart
        options: {
          scales: {
            yAxes: [{
              ticks: {
                beginAtZero: false,
              },
              gridLines: {
                display: true
              }
            }],
            xAxes: [ {
              gridLines: {
                display: false
              }
            }]
          },
          legend: {
            display: true
          },
          responsive: true,
          maintainAspectRatio: false
        }
      }
    },
    mounted () {
         axios
                .get('http://localhost:8000/covid19/global/today/total/week')
                .then(({data})=>{
                    this.items = data;
                    for(var i=0;i<this.items.length;i++){
                        this.datacollection.labels[i] = this.items[i].stdDay;
                        this.datacollection.datasets[0].data[i]=this.items[i].dayDefCnt;  
                  }
                this.renderChart(this.datacollection, this.options)
                })
                .catch(()=>{
                    console.log("오류");
                });
      //renderChart function renders the chart with the datacollection and options object.
     
    },
  }
</script>
<style scoped>

</style>