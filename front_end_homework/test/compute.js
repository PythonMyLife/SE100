message:[
    {
        id: 'CS902',
        name: '程序设计思想与方法',
        credit: 3,
        score: 86
    },{
        id: 'MA115',
        name: '离散数学',
        credit: 2,
        score: 95
    },{
        id: 'MA077',
        name: '线性代数',
        credit: 3,
        score: 86
    },{
        id: 'TH004',
        name: '军事理论',
        credit: 1,
        score: 90
    }
]
function compute(message){
    totalscore=0;
    message.forEach(function(mess){
        totalscore+=parseInt(mess.credit*mess.score);
    })
    return totalscore;
}

module.exports = compute;