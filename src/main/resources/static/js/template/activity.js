$(document).ready(function() {


    collectData("step");


    var activityBar = $('#myChart')
  //  var bar  = echarts.init(activityBar, null, {
    //    renderer: 'canvas',
     //   useDirtyRect: false
    //})

    //bar.setOption(option);

});

function collectData(type){
    const currentDate = new Date();
    const startDateStr = "" + currentDate.getFullYear() + "-" + getMonth(currentDate.getMonth() + 1) + "-" + currentDate.getDate()
    const endDate = new Date(new Date().setDate(currentDate.getDate() - 30));
    const endDateStr = "" + endDate.getFullYear() + "-" + getMonth(endDate.getMonth() + 1) + "-" + endDate.getDate()
    let data = {
        today:startDateStr,
        endDate:endDateStr,
        type: type,
        userId: 953
    }
    $.ajax({
        url: '/activities/chart',
        method: 'GET',
        contentType: 'application/json',
        data:data,
        success: function(response) {
            console.log(response)
        },
        error: function(error) {
            console.error('Error:', error);
        }
    });
}

function getMonth(value){
    if (value < 10){
        value = "0" + value
    }
    return value
}


option = {
    title: {
        text: 'Stacked Area Chart'
    },
    tooltip: {
        trigger: 'axis',
        axisPointer: {
            type: 'cross',
            label: {
                backgroundColor: '#6a7985'
            }
        }
    },
    legend: {
        data: ['Email', 'Union Ads', 'Video Ads', 'Direct', 'Search Engine']
    },
    toolbox: {
        feature: {
            saveAsImage: {}
        }
    },
    grid: {
        left: '3%',
        right: '4%',
        bottom: '3%',
        containLabel: true
    },
    xAxis: [
        {
            type: 'category',
            boundaryGap: false,
            data: ['Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat', 'Sun']
        }
    ],
    yAxis: [
        {
            type: 'value'
        }
    ],
    series: [
        {
            name: 'Email',
            type: 'line',
            stack: 'Total',
            areaStyle: {},
            emphasis: {
                focus: 'series'
            },
            data: [120, 132, 101, 134, 90, 230, 210]
        },
        {
            name: 'Union Ads',
            type: 'line',
            stack: 'Total',
            areaStyle: {},
            emphasis: {
                focus: 'series'
            },
            data: [220, 182, 191, 234, 290, 330, 310]
        },
        {
            name: 'Video Ads',
            type: 'line',
            stack: 'Total',
            areaStyle: {},
            emphasis: {
                focus: 'series'
            },
            data: [150, 232, 201, 154, 190, 330, 410]
        },
        {
            name: 'Direct',
            type: 'line',
            stack: 'Total',
            areaStyle: {},
            emphasis: {
                focus: 'series'
            },
            data: [320, 332, 301, 334, 390, 330, 320]
        },
        {
            name: 'Search Engine',
            type: 'line',
            stack: 'Total',
            label: {
                show: true,
                position: 'top'
            },
            areaStyle: {},
            emphasis: {
                focus: 'series'
            },
            data: [820, 932, 901, 934, 1290, 1330, 1320]
        }
    ]
};

