const readline = require('readline');

const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});


let N;
let cnt = 0;
let hashmap = {};
let basket = [];
let answer = [];
rl.on('line', function(line){
    if(cnt % 2 === 0){
        N = parseInt(line);
    }else if(cnt === 1){
        basket = line.split(' ').map(String);
        for(let i = 0; i < N; i++){
            if(basket[i] in hashmap){
                hashmap[basket[i]]++;
            }else{
                hashmap[basket[i]] = 1;
            }
        }
    }else{
        basket = line.split(' ');
        for(let i = 0; i < N; i++){
            if(basket[i] in hashmap){
                answer[i] = hashmap[basket[i]];
            }else{
                answer[i] = 0;
            }
        }
        rl.close();
    }
    cnt++;
}).on('close', function(){
    console.log(answer.join(' '));
})