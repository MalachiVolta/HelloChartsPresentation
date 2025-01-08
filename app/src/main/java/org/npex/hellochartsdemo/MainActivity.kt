package org.npex.hellochartsdemo

import android.os.Bundle
import android.widget.Button
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity
import lecho.lib.hellocharts.model.BubbleChartData
import lecho.lib.hellocharts.model.BubbleValue
import lecho.lib.hellocharts.model.Line
import lecho.lib.hellocharts.model.LineChartData
import lecho.lib.hellocharts.model.PieChartData
import lecho.lib.hellocharts.model.PointValue
import lecho.lib.hellocharts.model.SliceValue
import lecho.lib.hellocharts.model.ValueShape
import lecho.lib.hellocharts.util.ChartUtils
import lecho.lib.hellocharts.view.BubbleChartView
import lecho.lib.hellocharts.view.LineChartView
import lecho.lib.hellocharts.view.PieChartView

class MainActivity : AppCompatActivity() {

    private lateinit var chartContainer: FrameLayout
    private lateinit var lineChartView: LineChartView
    private lateinit var bubbleChartView: BubbleChartView
    private lateinit var pieChartView: PieChartView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        chartContainer = findViewById(R.id.chartContainer)

        lineChartView = createLineChart()
        bubbleChartView = createBubbleChart()
        pieChartView = createPieChart()

        val lineChartButton = findViewById<Button>(R.id.lineChartButton)
        val bubbleChartButton = findViewById<Button>(R.id.bubbleChartButton)
        val pieChartButton = findViewById<Button>(R.id.pieChartButton)

        lineChartButton.setOnClickListener {
            switchChart(lineChartView)
        }
        bubbleChartButton.setOnClickListener {
            switchChart(bubbleChartView)
        }
        pieChartButton.setOnClickListener {
            switchChart(pieChartView)
        }

        switchChart(lineChartView)
    }

    private fun switchChart(chartView: android.view.View) {
        chartContainer.removeAllViews()
        chartContainer.addView(chartView)
    }


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
