const express = require('express');
const fs = require('fs');

const app = express();

app.use(express.json());
app.use(express.urlencoded({extended:true, limit: '5MB'}));
app.post('/testeUpload', (req, res) => {

//? req.body - envio do aquivo de la para cá
    let buffer = new Buffer.from(req.body.file, 'base64');
    let imageName = './uploads/' + Date.now.toString() + '.jpg';
    
    fs.writeFileSync(imageName, buffer, 'base64', (error)=>{
       
        if(error) console.log(error);

    });

});

app.listen(3000, ()=>{
    console.log("SERVIDOR RODANDO EM http://localhost:3000")
})