const fs = require('fs');
const conteudo = fs.readFileSync('texto.txt', 'utf8');
console.log(conteudo);