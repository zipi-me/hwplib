package kr.dogfoot.hwplib.test;

import kr.dogfoot.hwplib.object.HWPFile;
import kr.dogfoot.hwplib.object.bodytext.Section;
import kr.dogfoot.hwplib.object.bodytext.paragraph.Paragraph;
import kr.dogfoot.hwplib.reader.HWPReader;
import kr.dogfoot.hwplib.writer.HWPWriter;

import java.io.File;

public class TestEditingHWPFile {
	public static void main(String[] args) throws Exception {
		String filename = "sample_hwp" + File.separator + "test-blank.hwp";
		
		HWPFile hwpFile = HWPReader.fromFile(filename);
		if (hwpFile != null) {
			Section s = hwpFile.getBodyText().getSectionList().get(0);
			Paragraph firstParagraph = s.getParagraph(0);
			firstParagraph.getText().addString("이것은 추가된 문자열입니다.");
			
			String writePath = filename.substring(0, 11) + "ed-" + filename.substring(11);
			HWPWriter.toFile(hwpFile, writePath);
		}
	}
}
