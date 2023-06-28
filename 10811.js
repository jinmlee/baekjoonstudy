const readline = require('readline');

const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});

let basket = [];
let N,M;

rl.on('line', function(line){
    if(!basket.length){
        [N, M] = line.split(' ').map(Number);
        for(let i = 1; i <= N; i++){
            basket[i - 1] = i;
        }
    }else{
        let [start, end] = line.split(' ').map(Number);
        while(start < end){
            let swap = basket[start - 1];
            basket[start - 1] = basket[end - 1];
            basket[end - 1] = swap;
            start++;
            end--;
        }
        
    }
    M--;
    if(M < 0){
        rl.close();
    }
}).on('close', function(){
    console.log(basket.join(' '));
})