var stats = {
    type: "GROUP",
name: "Global Information",
path: "",
pathFormatted: "group_missing-name-b06d1",
stats: {
    "name": "Global Information",
    "numberOfRequests": {
        "total": "10",
        "ok": "10",
        "ko": "0"
    },
    "minResponseTime": {
        "total": "1061",
        "ok": "1061",
        "ko": "-"
    },
    "maxResponseTime": {
        "total": "1336",
        "ok": "1336",
        "ko": "-"
    },
    "meanResponseTime": {
        "total": "1211",
        "ok": "1211",
        "ko": "-"
    },
    "standardDeviation": {
        "total": "91",
        "ok": "91",
        "ko": "-"
    },
    "percentiles1": {
        "total": "1207",
        "ok": "1207",
        "ko": "-"
    },
    "percentiles2": {
        "total": "1296",
        "ok": "1296",
        "ko": "-"
    },
    "percentiles3": {
        "total": "1333",
        "ok": "1333",
        "ko": "-"
    },
    "percentiles4": {
        "total": "1335",
        "ok": "1335",
        "ko": "-"
    },
    "group1": {
    "name": "t < 800 ms",
    "count": 0,
    "percentage": 0
},
    "group2": {
    "name": "800 ms < t < 1200 ms",
    "count": 4,
    "percentage": 40
},
    "group3": {
    "name": "t > 1200 ms",
    "count": 6,
    "percentage": 60
},
    "group4": {
    "name": "failed",
    "count": 0,
    "percentage": 0
},
    "meanNumberOfRequestsPerSecond": {
        "total": "5",
        "ok": "5",
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
        "total": "10",
        "ok": "10",
        "ko": "0"
    },
    "minResponseTime": {
        "total": "1061",
        "ok": "1061",
        "ko": "-"
    },
    "maxResponseTime": {
        "total": "1336",
        "ok": "1336",
        "ko": "-"
    },
    "meanResponseTime": {
        "total": "1211",
        "ok": "1211",
        "ko": "-"
    },
    "standardDeviation": {
        "total": "91",
        "ok": "91",
        "ko": "-"
    },
    "percentiles1": {
        "total": "1207",
        "ok": "1207",
        "ko": "-"
    },
    "percentiles2": {
        "total": "1296",
        "ok": "1296",
        "ko": "-"
    },
    "percentiles3": {
        "total": "1333",
        "ok": "1333",
        "ko": "-"
    },
    "percentiles4": {
        "total": "1335",
        "ok": "1335",
        "ko": "-"
    },
    "group1": {
    "name": "t < 800 ms",
    "count": 0,
    "percentage": 0
},
    "group2": {
    "name": "800 ms < t < 1200 ms",
    "count": 4,
    "percentage": 40
},
    "group3": {
    "name": "t > 1200 ms",
    "count": 6,
    "percentage": 60
},
    "group4": {
    "name": "failed",
    "count": 0,
    "percentage": 0
},
    "meanNumberOfRequestsPerSecond": {
        "total": "5",
        "ok": "5",
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
