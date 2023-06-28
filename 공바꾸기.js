const readline = require('readline');

const rl = readline.createInterface({
    input: process.stdin,   
    output: process.stdout
});

let basket = [];
let N,M;

rl.on('line', function (line) {
    if(!basket.length){
        [N, M] = line.split(" ").map(Number);
        for(let i = 1; i <= N; i++){
            basket[i - 1] = i;
        }
    }else{
        let [pick1, pick2] = line.split(" ").map(Number);
        let swap = basket[pick1 - 1];
        basket[pick1 - 1] = basket[pick2 - 1];
        basket[pick2 - 1] = swap;
    }
    M--;
    if(M < 0){
        rl.close();
    }
}).on('close', function(){
    console.log(basket.join(' '));
})


