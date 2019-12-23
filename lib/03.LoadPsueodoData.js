
db = db.getSisterDB("stockdb")

db.stocks.drop()

let e = 1
let prefix = ""

for (let i = 0; i < 100 ; i ++){
	
	if (i % 10 == 0){
		e++
		if (e <= 9) {
			prefix = "0"
		}
		else {
			prefix = ""
		}
	}
    
	category = "e-" + prefix + e
    let data = {_id: i, symbol: 'ibm-' + i,  name: "international business machine-" + i
		            , price: 20 + i, 
    		        category  }
    
	db.stocks.insert(data)
}
