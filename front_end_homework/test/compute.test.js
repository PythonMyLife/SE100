var compute = require('./compute.js');
var expect = require('chai').expect;

message1=[
    {
        id: 'CS902',
        name: '程序设计思想与方法',
        credit: 1,
        score: 100
    }
]

message2=[
    {
        id: 'CS902',
        name: '程序设计思想与方法',
        credit: 1,
        score: 100
    },{
        id: 'MA115',
        name: '离散数学',
        credit: 1,
        score: 90
    }
]

message3=[
    {
        id: 'CS902',
        name: '程序设计思想与方法',
        credit: 3,
        score: 90
    },{
        id: 'MA115',
        name: '离散数学',
        credit: 2,
        score: 80
    },{
        id: 'MA077',
        name: '线性代数',
        credit: 3,
        score: 90
    },{
        id: 'TH004',
        name: '军事理论',
        credit: 1,
        score: 90
    }
]

describe('计算函数的测试',function(){
    it('message1计算的结果应该为100',function(){
        expect(compute(message1)).to.be.equal(100);
    });

    it('message2计算的结果应该为190',function(){
        expect(compute(message2)).to.be.equal(190);
    });

    it('message3计算的结果应该为790',function(){
        expect(compute(message3)).to.be.equal(790);
    });
});