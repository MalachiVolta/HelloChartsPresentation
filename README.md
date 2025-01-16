# HelloCharts App
[HelloCharts Repo](https://github.com/lecho/hellocharts-android)

## 🕹️ Zakaj HelloCharts?
HelloCharts je brezplačna odprtokodna knjižnica za prikaz grafov in diagramov v Android aplikacijah. Je zelo enostavna za uporabo in ponuja veliko različnih opcij za prikaz želenih podatkov v različnih oblikah.
Omogoča tudi interaktivnost s temi grafi, da lahko podatke bolj podrobno opazujemo in analiziramo.

## 🔄 Prednosti
- Je popolnoma brezplačna
- Veliko vrst grafov kot so npr. črtni grafi, stolpčni grafi, okrogli grafi, ...
- Omogoča interaktivno gledanje grafov
- Zelo enostavno za integracijo z malo kode

## 🚫 Slabosti
- Omejene funkcionalnosti v primerjavi z naprednejšimi knjižnicami.
- Manj poznana knjižnjica in zato posledično majn virov za zgled pri implementaciji, kot mogoče pri drugih
- Zaradi starosti knjižnjice pride do konfliktov dependency-jev, kar ustvari potrebo po uporabi Jetifier

## 🔹 Statistike Projekta (8.1.2025)
![Forks](https://img.shields.io/github/forks/lecho/hellocharts-android?style=social)

![Watchers](https://img.shields.io/github/watchers/lecho/hellocharts-android?style=social)

![Star History](https://api.lucabubi.me/chart?username=lecho&repository=hellocharts-android&color=green)

![Stars](https://img.shields.io/github/stars/lecho/hellocharts-android?style=social)

## 🌐 Posodobitve
- **Zadnji Commit**: Pred 7 leti, zadnji release 27. Septembra 2015
- **Stanje**: Trenutni ni aktivnega razvoja
- **Issues**: Ima 283 issues, samo niso nobeni dovolj rizični, da bi vplivali na povprečno uporabo

## 🛡️ Licenca
HelloCharts uporablja standardno **APACHE-2.0 licenco**. 
Apache 2.0 licenca omogoča prosto uporabo, spreminjanje in distribucijo programske opreme, pod pogojem, da se ohranijo zapisi o prejšnjih avtorjih.

## 📖 Primeri Uporabe

![studio64_8JNwTYlQpw](https://github.com/user-attachments/assets/dbafa61d-802c-4258-bac6-83afe7d912ca)

```kotlin
    private fun createLineChart(): LineChartView {
        val lineChartView = LineChartView(this)
        val lineData = LineChartData().apply {
            val lines = ArrayList<Line>()
            val values = arrayListOf(
                PointValue(0f, 1f),
                PointValue(1f, 3f),
                PointValue(2f, 2f),
                PointValue(3f, 5f),
                PointValue(4f, 4f)
            )
            val line = Line(values).apply {
                color = resources.getColor(android.R.color.holo_blue_dark)
                isCubic = true
                setHasLabels(true)
            }
            lines.add(line)
            this.lines = lines
        }
        lineChartView.lineChartData = lineData
        return lineChartView
    }
```

![studio64_ySGXcjNNyI](https://github.com/user-attachments/assets/dd51ef9c-ae21-49eb-b11b-025337c71dbb)

```kotlin
    private fun createBubbleChart(): BubbleChartView {
        val bubbleChartView = BubbleChartView(this)
        val bubbleData = BubbleChartData().apply {
            val bubbles = ArrayList<BubbleValue>()
            for (i in 0 until 5) {
                val value = BubbleValue(
                    i.toFloat(),
                    Math.random().toFloat() * 100,
                    Math.random().toFloat() * 1000
                )
                value.setColor(ChartUtils.pickColor())
                value.setShape(ValueShape.CIRCLE)
                bubbles.add(value)
            }
            values = bubbles
        }
        bubbleChartView.bubbleChartData = bubbleData
        return bubbleChartView
    }

```

![studio64_yBzaHDJVqY](https://github.com/user-attachments/assets/f4571593-b505-4568-8b48-3a3c47f5903d)

```kotlin
    private fun createPieChart(): PieChartView {
        val pieChartView = PieChartView(this)
        val pieData = PieChartData().apply {
            val pieSlices = arrayListOf(
                SliceValue(30f, resources.getColor(android.R.color.holo_red_dark)),
                SliceValue(20f, resources.getColor(android.R.color.holo_blue_dark)),
                SliceValue(50f, resources.getColor(android.R.color.holo_green_dark))
            )
            values = pieSlices
        }
        pieChartView.pieChartData = pieData
        return pieChartView
    }
}

```

## Uporaba v projektni nalogi

![studio64_DUX526r5uW](https://github.com/user-attachments/assets/2fc9e815-43ca-4513-b2bf-a7fd51224a10)
