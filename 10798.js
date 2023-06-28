const readlin = require('readline');

const rl = readlin.createInterface({
    input: process.stdin,
    output: process.stdout
});

const basket = [];
const answer = [];
let cnt = 5;

rl.on('line', function(line){
    basket.push(line.trim());
    cnt--;
    if(cnt === 0){
        get_str();
        rl.close();
    }
}).on('close', function(){
    console.log(answer.join(''));
})

function get_str(){
    for(let i = 0; i < 15; i++){
        for(let j = 0; j < 5; j++){
            if(basket[j][i] === null)
                continue;
            else{
                answer.push(basket[j][i]);
            }
        }
    }
}