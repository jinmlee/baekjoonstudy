const readline = require('readline');

const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});


rl.on('line', function(line){
    const [N, M] = line.split(' ').map(Number);
    const q = [];
    const answer = [];
    for(let i = 1; i <= N; i++){
        q.push(i);
    }
    while(q.length > 0){
        for(let i = 0; i < M - 1; i++){
            q.push(q.shift());
        }
        answer.push(q.shift());
    }
    console.log(`<${answer.join(', ')}>`);
    rl.close();
}).on('close', function(){
    process.exit(0);
});