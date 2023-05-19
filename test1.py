import requests
import json


print("Python script to get the lowest and peak population growth:" + "\n")


res = requests.get('https://datausa.io/api/data?drilldowns=Nation&measures=Population')
var = json.loads(res.text) #dict

dataList = var['data']
sourceList = var['source']
yearsList = list()
populationList = list()
growthList = list()
growthPercentList = list()
pop_year = dict()

#create the years list
for year in dataList:
	yearsList.append(year['Year'])

yearsList.sort() #sort in ascending order
#completeYearsList = yearsList

numOfYears = len(yearsList) # get no of years

#get start and end years
startYear = min(yearsList)
endYear = max(yearsList)

for item in sourceList:
	name = item['annotations']['source_name'] #get the source name

#create pupulation list
for item in dataList:
	population  = item['Population']
	year = item['Year']
	pop_year[year] = population
	populationList.append(item['Population'])

populationList.sort() #sort in ascending order
initialValue = populationList[0] #set the initial value based on which growth rates need to be calculated

#create population growth percent list
for value in populationList:
	growth = value-initialValue
	percent = growth/initialValue
	growthList.append(growth)
	growthPercentList.append(percent*100)
	initialValue = value

growthPercentList.remove(growthPercentList[0]) #remove the first item as we don't know the growth in the first year
#yearsList.remove(yearsList[0]) #remove the first item as we don't know the growth in the first year

lowestGrowth = min(growthPercentList) #get the lowest growth percent value
peakGrowth = max(growthPercentList) #get the peak growth percent value
lowestGrowthYear = yearsList[growthPercentList.index(lowestGrowth)+1] #get the lowest growth percent year
peakGrowthYear = yearsList[growthPercentList.index(peakGrowth)+1] #get the peak growth percent year


#create the output message. Either one can be used
output1 = "According to " + name + ", in " + str(yearsList) + " years from " + str(startYear) + " to " + str(endYear) + ", peak population growth was " + str(peakGrowth) + "% in " + peakGrowthYear + " and the lowest population increase was " + str(lowestGrowth) + "% in " + lowestGrowthYear
output2 = "According to " + name + ", in " + str(numOfYears) + " years from " + str(startYear) + " to " + str(endYear) + ", peak population growth was " + str(peakGrowth) + "% in " + peakGrowthYear + " and the lowest population increase was " + str(lowestGrowth) + "% in " + lowestGrowthYear

print("Output1:" + "\n" + output1) #print the output message
print("\nOutput2:" + "\n" + output2) #print the output message
