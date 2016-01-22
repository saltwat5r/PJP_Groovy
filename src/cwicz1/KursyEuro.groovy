package cwicz1
import groovy.swing.SwingBuilder

def url = 'http://www.ecb.europa.eu/stats/eurofxref/eurofxref-daily.xml'
def rates = new XmlParser().parse(url)

def map = [:]

rates.Cube.Cube.Cube.each {
	map[it.@currency] = it.@rate 
}

new SwingBuilder().edt {
	frame(title: 'Euro rates', pack: true, visible: true) {
		panel() {
			comboBox(id: 'cb', border: titledBorder('Select currency'), prototypeDisplayValue: 'xxxxxxxxxxxxxxx',
				items: map.keySet().toList(),
				actionPerformed: {
					def cur = it.source.selectedItem
					lab.text = map[cur]
				})
			label(id: 'lab', preferredSize: cb.preferredSize, border: titledBorder('Rate'))
		}
	}
}