var stats = {
    type: "GROUP",
name: "Global Information",
path: "",
pathFormatted: "group_missing-name-b06d1",
stats: {
    "name": "Global Information",
    "numberOfRequests": {
        "total": "2",
        "ok": "2",
        "ko": "0"
    },
    "minResponseTime": {
        "total": "61",
        "ok": "61",
        "ko": "-"
    },
    "maxResponseTime": {
        "total": "1687",
        "ok": "1687",
        "ko": "-"
    },
    "meanResponseTime": {
        "total": "874",
        "ok": "874",
        "ko": "-"
    },
    "standardDeviation": {
        "total": "813",
        "ok": "813",
        "ko": "-"
    },
    "percentiles1": {
        "total": "874",
        "ok": "874",
        "ko": "-"
    },
    "percentiles2": {
        "total": "1281",
        "ok": "1281",
        "ko": "-"
    },
    "percentiles3": {
        "total": "1606",
        "ok": "1606",
        "ko": "-"
    },
    "percentiles4": {
        "total": "1671",
        "ok": "1671",
        "ko": "-"
    },
    "group1": {
    "name": "t < 800 ms",
    "count": 1,
    "percentage": 50
},
    "group2": {
    "name": "800 ms < t < 1200 ms",
    "count": 0,
    "percentage": 0
},
    "group3": {
    "name": "t > 1200 ms",
    "count": 1,
    "percentage": 50
},
    "group4": {
    "name": "failed",
    "count": 0,
    "percentage": 0
},
    "meanNumberOfRequestsPerSecond": {
        "total": "1",
        "ok": "1",
        "ko": "-"
    }
},
contents: {
"req_homepage-reques-447b6": {
        type: "REQUEST",
        name: "Homepage_request",
path: "Homepage_request",
pathFormatted: "req_homepage-reques-447b6",
stats: {
    "name": "Homepage_request",
    "numberOfRequests": {
        "total": "1",
        "ok": "1",
        "ko": "0"
    },
    "minResponseTime": {
        "total": "1687",
        "ok": "1687",
        "ko": "-"
    },
    "maxResponseTime": {
        "total": "1687",
        "ok": "1687",
        "ko": "-"
    },
    "meanResponseTime": {
        "total": "1687",
        "ok": "1687",
        "ko": "-"
    },
    "standardDeviation": {
        "total": "0",
        "ok": "0",
        "ko": "-"
    },
    "percentiles1": {
        "total": "1687",
        "ok": "1687",
        "ko": "-"
    },
    "percentiles2": {
        "total": "1687",
        "ok": "1687",
        "ko": "-"
    },
    "percentiles3": {
        "total": "1687",
        "ok": "1687",
        "ko": "-"
    },
    "percentiles4": {
        "total": "1687",
        "ok": "1687",
        "ko": "-"
    },
    "group1": {
    "name": "t < 800 ms",
    "count": 0,
    "percentage": 0
},
    "group2": {
    "name": "800 ms < t < 1200 ms",
    "count": 0,
    "percentage": 0
},
    "group3": {
    "name": "t > 1200 ms",
    "count": 1,
    "percentage": 100
},
    "group4": {
    "name": "failed",
    "count": 0,
    "percentage": 0
},
    "meanNumberOfRequestsPerSecond": {
        "total": "0.5",
        "ok": "0.5",
        "ko": "-"
    }
}
    },"req_googlelogo-whit-acf63": {
        type: "REQUEST",
        name: "googlelogo_white_background_color_272x92dp.png",
path: "googlelogo_white_background_color_272x92dp.png",
pathFormatted: "req_googlelogo-whit-acf63",
stats: {
    "name": "googlelogo_white_background_color_272x92dp.png",
    "numberOfRequests": {
        "total": "1",
        "ok": "1",
        "ko": "0"
    },
    "minResponseTime": {
        "total": "61",
        "ok": "61",
        "ko": "-"
    },
    "maxResponseTime": {
        "total": "61",
        "ok": "61",
        "ko": "-"
    },
    "meanResponseTime": {
        "total": "61",
        "ok": "61",
        "ko": "-"
    },
    "standardDeviation": {
        "total": "0",
        "ok": "0",
        "ko": "-"
    },
    "percentiles1": {
        "total": "61",
        "ok": "61",
        "ko": "-"
    },
    "percentiles2": {
        "total": "61",
        "ok": "61",
        "ko": "-"
    },
    "percentiles3": {
        "total": "61",
        "ok": "61",
        "ko": "-"
    },
    "percentiles4": {
        "total": "61",
        "ok": "61",
        "ko": "-"
    },
    "group1": {
    "name": "t < 800 ms",
    "count": 1,
    "percentage": 100
},
    "group2": {
    "name": "800 ms < t < 1200 ms",
    "count": 0,
    "percentage": 0
},
    "group3": {
    "name": "t > 1200 ms",
    "count": 0,
    "percentage": 0
},
    "group4": {
    "name": "failed",
    "count": 0,
    "percentage": 0
},
    "meanNumberOfRequestsPerSecond": {
        "total": "0.5",
        "ok": "0.5",
        "ko": "-"
    }
}
    }
}

}

function fillStats(stat){
    $("#numberOfRequests").append(stat.numberOfRequests.total);
    $("#numberOfRequestsOK").append(stat.numberOfRequests.ok);
    $("#numberOfRequestsKO").append(stat.numberOfRequests.ko);

    $("#minResponseTime").append(stat.minResponseTime.total);
    $("#minResponseTimeOK").append(stat.minResponseTime.ok);
    $("#minResponseTimeKO").append(stat.minResponseTime.ko);

    $("#maxResponseTime").append(stat.maxResponseTime.total);
    $("#maxResponseTimeOK").append(stat.maxResponseTime.ok);
    $("#maxResponseTimeKO").append(stat.maxResponseTime.ko);

    $("#meanResponseTime").append(stat.meanResponseTime.total);
    $("#meanResponseTimeOK").append(stat.meanResponseTime.ok);
    $("#meanResponseTimeKO").append(stat.meanResponseTime.ko);

    $("#standardDeviation").append(stat.standardDeviation.total);
    $("#standardDeviationOK").append(stat.standardDeviation.ok);
    $("#standardDeviationKO").append(stat.standardDeviation.ko);

    $("#percentiles1").append(stat.percentiles1.total);
    $("#percentiles1OK").append(stat.percentiles1.ok);
    $("#percentiles1KO").append(stat.percentiles1.ko);

    $("#percentiles2").append(stat.percentiles2.total);
    $("#percentiles2OK").append(stat.percentiles2.ok);
    $("#percentiles2KO").append(stat.percentiles2.ko);

    $("#percentiles3").append(stat.percentiles3.total);
    $("#percentiles3OK").append(stat.percentiles3.ok);
    $("#percentiles3KO").append(stat.percentiles3.ko);

    $("#percentiles4").append(stat.percentiles4.total);
    $("#percentiles4OK").append(stat.percentiles4.ok);
    $("#percentiles4KO").append(stat.percentiles4.ko);

    $("#meanNumberOfRequestsPerSecond").append(stat.meanNumberOfRequestsPerSecond.total);
    $("#meanNumberOfRequestsPerSecondOK").append(stat.meanNumberOfRequestsPerSecond.ok);
    $("#meanNumberOfRequestsPerSecondKO").append(stat.meanNumberOfRequestsPerSecond.ko);
}
