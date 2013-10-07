<?xml version="1.0" encoding="ISO-8859-1" ?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
  <xsl:output method="xml" indent="yes"/>
  <xsl:param name="specMode" select="'false'"/>

  <xsl:template match="project">
    <html>
      <head>
        <title>
          <xsl:value-of select="@name"/>
        </title>
      </head>
      <body>
        <h1>Project:
          <xsl:value-of select="@name"/>
        </h1>
        <xsl:call-template name="addInfo"/>
        <xsl:apply-templates select="suite"/>
      </body>
    </html>
  </xsl:template>

  <xsl:template match="suite">
    <h2>Suite:
      <xsl:value-of select="@name"/>
    </h2>
    <xsl:call-template name="addInfo"/>
    <xsl:apply-templates select="case"/>
  </xsl:template>

  <xsl:template match="case">
    <h3>TestCase:
      <xsl:value-of select="@name"/>
    </h3>
    <xsl:call-template name="addInfo"/>
    <xsl:apply-templates select="test"/>
  </xsl:template>

  <xsl:template match="test">
    <h4>Test:
      <xsl:value-of select="@name"/>
    </h4>
    <xsl:call-template name="addInfo"/>
    <table border="1" cellPadding="1" cellSpacing="0">
      <tr bgcolor="gray">
        <th>Step</th>
        <th>Stimuli</th>
        <th>Expected result</th>
        <xsl:if test="$specMode='false'">
          <th colspan="2">Result</th>
        </xsl:if>
        <xsl:if test="$specMode!='false'">
          <th>Result</th>
        </xsl:if>
      </tr>
      <xsl:apply-templates select="step"/>
    </table>
    <xsl:if test="$specMode='false'">
      <xsl:call-template name="addTestResult"/>
    </xsl:if>
  </xsl:template>

  <xsl:template match="step">
    <tr>
      <td width="3%">
        <xsl:value-of select="number"/>
      </td>
      <td width="48%"><xsl:value-of select="stimuli" disable-output-escaping="yes"/>&#160;
      </td>
      <td width="48%"><xsl:value-of select="expectedResult" disable-output-escaping="yes"/>&#160;
      </td>
      <xsl:if test="$specMode='false'">
        <td width="4%" align="center">
          <xsl:value-of select="@outcome" disable-output-escaping="yes"/>
        </td>
      </xsl:if>
      <xsl:if test="$specMode!='false'">
        <td width="23%">&#160;</td>
      </xsl:if>
    </tr>
  </xsl:template>

  <xsl:template match="def">
    <xsl:value-of select="@name"/>
    <br/>
  </xsl:template>

  <xsl:template match="ref">
    <xsl:value-of select="@name"/>
    <br/>
  </xsl:template>

  <xsl:template match="failure">
    <xsl:value-of select="@name"/>
    <br/>
  </xsl:template>

  <xsl:template match="error">
    <xsl:value-of select="@name"/>
    <br/>
  </xsl:template>

  <xsl:template name="addInfo">
    <xsl:if test="def">
      <b>Purpose</b>
      <br/>
      <xsl:apply-templates select="def"/>
      <br/>
    </xsl:if>
    <xsl:if test="ref">
      <b>References</b>
      <br/>
      <xsl:apply-templates select="ref"/>
      <br/>
    </xsl:if>
    <xsl:if test="@setup">
      <b>Setup Action</b>
      <br/>
      <xsl:value-of select="@setup"/>
      <br/>
      <br/>
    </xsl:if>
    <xsl:if test="@teardown">
      <b>Teardown Action</b>
      <br/>
      <xsl:value-of select="@teardown"/>
      <br/>
      <br/>
    </xsl:if>
  </xsl:template>

  <xsl:template name="addTestResult">
    <xsl:if test="failure">
      <br/>
      <b>
        <font color="red">Test failed:</font>
      </b>
      <xsl:apply-templates select="failure"/>
      <br/>
    </xsl:if>
    <xsl:if test="error">
      <br/>
      <b>
        <font color="red">Test error:</font>
      </b>
      <xsl:apply-templates select="error"/>
      <br/>
    </xsl:if>
    <!--xsl:value-of select="@testresult"/><br/-->
  </xsl:template>

</xsl:stylesheet>
