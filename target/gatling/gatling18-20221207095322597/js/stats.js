var stats = {
    type: "GROUP",
name: "Global Information",
path: "",
pathFormatted: "group_missing-name-b06d1",
stats: {
    "name": "Global Information",
    "numberOfRequests": {
        "total": "1",
        "ok": "0",
        "ko": "1"
    },
    "minResponseTime": {
        "total": "585",
        "ok": "-",
        "ko": "585"
    },
    "maxResponseTime": {
        "total": "585",
        "ok": "-",
        "ko": "585"
    },
    "meanResponseTime": {
        "total": "585",
        "ok": "-",
        "ko": "585"
    },
    "standardDeviation": {
        "total": "0",
        "ok": "-",
        "ko": "0"
    },
    "percentiles1": {
        "total": "585",
        "ok": "-",
        "ko": "585"
    },
    "percentiles2": {
        "total": "585",
        "ok": "-",
        "ko": "585"
    },
    "percentiles3": {
        "total": "585",
        "ok": "-",
        "ko": "585"
    },
    "percentiles4": {
        "total": "585",
        "ok": "-",
        "ko": "585"
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
    "count": 0,
    "percentage": 0
},
    "group4": {
    "name": "failed",
    "count": 1,
    "percentage": 100
},
    "meanNumberOfRequestsPerSecond": {
        "total": "1",
        "ok": "-",
        "ko": "1"
    }
},
contents: {
"group_homepage-tx-7d295": {
          type: "GROUP",
name: "Homepage_tx",
path: "Homepage_tx",
pathFormatted: "group_homepage-tx-7d295",
stats: {
    "name": "Homepage_tx",
    "numberOfRequests": {
        "total": "1",
        "ok": "0",
        "ko": "1"
    },
    "minResponseTime": {
        "total": "585",
        "ok": "-",
        "ko": "585"
    },
    "maxResponseTime": {
        "total": "585",
        "ok": "-",
        "ko": "585"
    },
    "meanResponseTime": {
        "total": "585",
        "ok": "-",
        "ko": "585"
    },
    "standardDeviation": {
        "total": "0",
        "ok": "-",
        "ko": "0"
    },
    "percentiles1": {
        "total": "585",
        "ok": "-",
        "ko": "585"
    },
    "percentiles2": {
        "total": "585",
        "ok": "-",
        "ko": "585"
    },
    "percentiles3": {
        "total": "585",
        "ok": "-",
        "ko": "585"
    },
    "percentiles4": {
        "total": "585",
        "ok": "-",
        "ko": "585"
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
    "count": 0,
    "percentage": 0
},
    "group4": {
    "name": "failed",
    "count": 1,
    "percentage": 100
},
    "meanNumberOfRequestsPerSecond": {
        "total": "1",
        "ok": "-",
        "ko": "1"
    }
},
contents: {
"req_homepage-reques-447b6": {
        type: "REQUEST",
        name: "Homepage_request",
path: "Homepage_tx / Homepage_request",
pathFormatted: "req_homepage-tx---h-deb87",
stats: {
    "name": "Homepage_request",
    "numberOfRequests": {
        "total": "1",
        "ok": "0",
        "ko": "1"
    },
    "minResponseTime": {
        "total": "585",
        "ok": "-",
        "ko": "585"
    },
    "maxResponseTime": {
        "total": "585",
        "ok": "-",
        "ko": "585"
    },
    "meanResponseTime": {
        "total": "585",
        "ok": "-",
        "ko": "585"
    },
    "standardDeviation": {
        "total": "0",
        "ok": "-",
        "ko": "0"
    },
    "percentiles1": {
        "total": "585",
        "ok": "-",
        "ko": "585"
    },
    "percentiles2": {
        "total": "585",
        "ok": "-",
        "ko": "585"
    },
    "percentiles3": {
        "total": "585",
        "ok": "-",
        "ko": "585"
    },
    "percentiles4": {
        "total": "585",
        "ok": "-",
        "ko": "585"
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
    "count": 0,
    "percentage": 0
},
    "group4": {
    "name": "failed",
    "count": 1,
    "percentage": 100
},
    "meanNumberOfRequestsPerSecond": {
        "total": "1",
        "ok": "-",
        "ko": "1"
    }
}
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
