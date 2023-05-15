package com.backend.core.util

import org.apache.poi.hssf.usermodel.HSSFSheet
import org.apache.poi.hssf.usermodel.HSSFWorkbook
import org.springframework.core.io.InputStreamResource
import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream

object ExcelGenerator {

    fun <T> generateWorkbook(
        headers: List<String>,
        summary: String?,
        contents: List<T>
    ): InputStreamResource {
        var rowIndex = 0
        val workbook = HSSFWorkbook()
        val sheet = workbook.createSheet()

        summary?.let {
            sheet.createRow(rowIndex++).createCell(0).setCellValue(summary)
        }

        val headerRow = sheet.createRow(rowIndex++)
        headers.forEachIndexed { index, value ->
            headerRow.createCell(index).setCellValue(value)
        }

        return writeContents(workbook, sheet, rowIndex, contents)
    }

    private fun <T> writeContents(
        workbook: HSSFWorkbook,
        sheet: HSSFSheet,
        rowIndex: Int,
        contents: List<T>,
    ): InputStreamResource {
        contents.forEachIndexed { index, value ->
            val valueRow = sheet.createRow(rowIndex + index)
            valueRow.createCell(index).setCellValue("$value")
        }
        return try {
            val out = ByteArrayOutputStream()
            workbook.write(out)
            val excelItem = ByteArrayInputStream(out.toByteArray())
            InputStreamResource(excelItem)
        } catch (e: Exception) {
            throw RuntimeException("failed to generate excel")
        }
    }
}
