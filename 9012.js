const readline = require('readline');

const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});

let N = 0;
rl.on('line', function(line){
    if(N === 0){
        N = parseInt(line);
    }else{
        check(line);
        N--;
    }
    if(N === 0){
        rl.close();
    }
}).on('close', function(){
    process.exit(0);
})
function check(box){
    const stack = [];
    for(let i = 0; i < box.length; i++){
        if(box[i] === '(')
            stack.push(box[i]);
        else{
            if(stack.length === 0){
                stack.push('-');
                break;
            }
            stack.pop();
        }
    }
    if(stack.length === 0){
        console.log('Yes');
    }else{
        console.log('No');
    }
}