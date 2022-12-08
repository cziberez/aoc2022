package aoc2022;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Nap03 {
    public static void main(String[] args) {
        System.out.println(megoldas1());
        System.out.println(megoldas2());
    }

    private static int megoldas1() {
        return Nap03.STRING_INPUT.lines().map(Nap03::commonCharsInLine).mapToInt(Nap03::sumChars).sum();
    }

    private static int megoldas2() {
        List<String> lines = Nap03.STRING_INPUT.lines().collect(Collectors.toList());
        return IntStream.iterate(0, i -> i < lines.size(), i -> i + 3)
                .mapToObj(i -> commonCharInLines(lines.get(i), lines.get(i + 1), lines.get(i + 2)))
                .mapToInt(Nap03::sumChars).sum();
    }

    private static Set<Character> commonCharInLines(String... lines) {
        return Arrays.stream(lines).map(Nap03::toSet).reduce((a, b) -> {
            a.retainAll(b);
            return a;
        }).orElseThrow();
    }

    private static Set<Character> commonCharsInLine(String line) {
        List<Character> list = toCharList(line);
        Set<Character> r1 = new HashSet<>(list.subList(0, list.size() / 2));
        Set<Character> r2 = new HashSet<>(list.subList(list.size() / 2, list.size()));
        r1.retainAll(r2);
        return r1;
    }

    private static List<Character> toCharList(String line) {
        return line.chars().mapToObj(i -> (char) i).collect(Collectors.toList());
    }

    private static Set<Character> toSet(String line) {
        return new HashSet<>(toCharList(line));
    }

    private static int sumChars(Collection<Character> chars) {
        return chars.stream().mapToInt(Nap03::charToInt).sum();
    }

    private static int charToInt(char ch) {
        if (Character.isLowerCase(ch)) {
            return (int) ch - (int) 'a' + 1;
        } else {
            return (int) ch - (int) 'A' + 27;
        }
    }

    private static final String STRING_INPUT = "shzsFcPssFhjFssBzdpRcNHNZrpdJdJVJZ\n" +
            "fwvMCntfCCbSbSbtDgDNrDtDtJHZVH\n" +
            "GbCwwbwwnGrLhBzjFFFsWPhL\n" +
            "PpCqRsqqmmtCwMJC\n" +
            "LHFrLLHDSNHlfWNhDzmjzzJlJzPJMvPJjQ\n" +
            "SGSWDNrhZhPDSWDZLgVVRgbRppgpGVnpnn\n" +
            "GRRjbVjmJZlgMRzzrN\n" +
            "FpDptHpfHfnpPTvDFTWpFPnPcMfNCClNrzcVcrMMzVsCZlsZ\n" +
            "TFTQDnvLHPFDtVbLwbjdGjdwwJ\n" +
            "lhljvvhCjjzhjszzBPmnmGVZMGzG\n" +
            "FbTcTwbtSFdtcMPnTBPQVnnBZT\n" +
            "SFMpHDtNDSSbSdwppvgJWjJCJJgWgvlJHH\n" +
            "wzNCWpzCzJnWWpRRNdJrgHLhjfbLrHrchV\n" +
            "lBMStmPmmLQDPQZlshrdhgrfrcrrddgHgs\n" +
            "mvGDGQSvDPBlGMLGCvCWpNvpzRWFwqRw\n" +
            "stBttBThtDZqPWssPWZp\n" +
            "gRggwwggCGFSBBvPRpHZZrHdZLZq\n" +
            "ccFJGCNJmmGQzbTDhnQhBBnB\n" +
            "HJqMqtZbJMmJTqtLtVMqhpfphNdQfhfzzjhhlHll\n" +
            "rWSBrnwFwWCvwWCwBgPgCgzjQccQhhgRzcdQzjfcNfzR\n" +
            "CWBCwCvCvvwssWLMtJJGMdMZJsGV\n" +
            "nFwSFQwsNrrsssSwCrhrCNnfcCRgJRMJTJcMfRzMCMCRvW\n" +
            "DdbGdLZLttllWWvTzgzzgR\n" +
            "ZqGzPdLtDjBjDZGPZVmnhQFwqrFQhVFnss\n" +
            "sNNpCjttjsJjSpgpWjslCTnqqSVffrnhSfDhmhrhfm\n" +
            "dBwcGzbPBHbbwZcwJbcTTFDFFFDVrdVmFdnDqf\n" +
            "HzGcczQPHGwzPzGHRctWlvRgtvJlvNlJvRNj\n" +
            "cFNCFdvcCHvFBCZcwBfRSpttGhDmCghGShmSRt\n" +
            "QjLnTTzQVzTTnLMqhDgPhGDDSjGPrgSh\n" +
            "TTJGnJJlLQdNWZWJNBJZ\n" +
            "WHBpHcMDZHLDbHLtGCnmRmLNGmRqvsCC\n" +
            "PzTFzPPTJzrSbGsvnmqfsqfqRz\n" +
            "dJSQQdVFQgjTrjQPWcWHbBVcZVccZtWp\n" +
            "JDtnRtJzNzTTNlHc\n" +
            "rQPJFrLPGMMwrGPFwjFMVLjSTWHdWBTdSWdWZlcWTHlZ\n" +
            "MGFrCvLLwrwPFVVhvLMGGtnqfsmRJgDnqbRgfbqmfC\n" +
            "jnTtFjcSSvctJjznzvFmpqqPMqQDRVpRqPzqQzVQ\n" +
            "bhHBfrWpfHsfGNllRrRCPqDCqPqq\n" +
            "gsGZZpbWgbwHWGNgfZNjvLSTTjtnTgjSSSSJmL\n" +
            "RLQNdVNnRQdQHVVLGpspNqvtsqptqpTtsp\n" +
            "MlRWwbRBBFMFjCTFTTFDvj\n" +
            "WmlWBmBwwmrndnmLRHRQ\n" +
            "WnftJWlfnWSHGCjWWWSCFqFGBDqBwMcDmmMmGmqD\n" +
            "pTNhpTrPhhhRPzbhrppLhThLgqDmwccwqPBmMMqnFBcwwmBB\n" +
            "ZrhQTpzdjSVVtnvZ\n" +
            "jgtnJtBjtlTdJBZJVQBngQGDCGWpPGCcPWCbWdWMbcpP\n" +
            "wHstNNttSHPDmHcMCp\n" +
            "rrFFSvLLNfsFtNSqrtfrhsNjjVTBVgVvnTBvTQvjTgjVZz\n" +
            "qhZwlqFqFwlJwrDHqHcDvgcNzv\n" +
            "RCCTQmjCbQTBtRTbjJRDpBrgDHPPpPDvHccDPc\n" +
            "VmjVWstQJhlJlGVJ\n" +
            "GggpGwZmgvgJMvbJFQQDbDFbBbFCQDCW\n" +
            "rtrLzNLtNSPnNqDSQDcQCWlqBQ\n" +
            "VtzdRPtztLtVRtZmmMTRwCGZpMwp\n" +
            "vtvqjsCqtshfjcWFHWGjGFJj\n" +
            "zGrnzDDMpPcTHcSTVTJP\n" +
            "DbDwMbZRDrZdBBnMznZMGZDfwtlgQhsqCttClsqvsLfCff\n" +
            "JLzLtLsrzsQdvrWRwMHwcc\n" +
            "qPmCTzlPjljjFTZmWwcwwvHMMRWwHvMm\n" +
            "PFqZnVCqTCNjCzNgQsbGBLzLQQ\n" +
            "CBnppDHllVpPCBshBHpjDTSmZcSrfwvmJcDDTJfw\n" +
            "dFRLdLFQzNSTBTSNmBJv\n" +
            "FzFFzRMBFWtQlPlsjjPVMnhC\n" +
            "CVCfwnfdVvBdBbTNTT\n" +
            "LNzsHPNWsDjTZqDHqT\n" +
            "PtLgQsGQLSzWLstPgGWcgQLSNrpplffrnrNhpVCwlGVlrwMn\n" +
            "jPPVqPsHffzVnHzvSgMcCJGGMSVCll\n" +
            "pdbpDpBLNmNNppJgcvgSllGjDSGQ\n" +
            "hrbBwLpjLhhhNZLhNrhZZLHzfsztFzzsrtHfRFnFfRHf\n" +
            "tdjBdbmSfdHBdHHmZlWjFrnlWQlqvMFvFn\n" +
            "pDNDJhLhPVPLLLJphJLwNcwnQTcWWTqTrqMWTZvqMrlvFM\n" +
            "gpVLhNwpgZJCghCLDNwphgmsBdzHHHmSstmfggzdbR\n" +
            "TfMpfMBVftLMDBSjWDHgzHbgwLgHHvdzggzs\n" +
            "QJnZcFFnZRHdHjJvwgdg\n" +
            "RjjRRnmNmmZNjZqZnQcVffBrWqVTqrtffTSTVV\n" +
            "fZTdTVcVjrjdBzdTnGtgnnGSHHNFGn\n" +
            "thMWPtPMslmGnWnNnS\n" +
            "thvbMvQMRphhLCjrzBjZVdcQfC\n" +
            "MpmgZFgMGdrFrBCVnJ\n" +
            "JsbJlTTlvLQbVffRRvBBRVjd\n" +
            "LWlbhHlJhLTJmmGcMMHNmNgN\n" +
            "bhvmhPrbhqNqQRRGzQjVvvRL\n" +
            "wTwBZDBTwwggfnngcDfdsVVFQCdzCzDVRsFdQs\n" +
            "pngWMcgzMgpZWncnMpWNrbNHrNbmHhltWlbl\n" +
            "nPndBjLPscWSccBVGnScsSzMdhMppMthdMgpMgrzvhhp\n" +
            "CCFTFDwqZqCCJmhvpDzztVzDNztp\n" +
            "qQFJTbRVbmCfwTwfmnnssWBGnLnWlRLSGn\n" +
            "JRlJDSvLRRCdvmDSvdlbZNVBSWZGNgWsZGNgZBVs\n" +
            "QrjPMqMnLzzjLjFnNNgBpsgtgGGGVZ\n" +
            "hrjrFqjqFrQfMHPhQzDvvCLJdwwwmvbJbwDH\n" +
            "HDGrDDDpNsGQNdZQ\n" +
            "jpjgtgjSjpjllfZZtZsvNdtshqqq\n" +
            "cbgMfjclWTJcMwjWJfpfmVPLPBnVBHnmVbnmLBbD\n" +
            "rPrMZNsNrsvrwqvFFFdgQWNzLJJzRW\n" +
            "pStppStHmcmHpgVSllVcbVbWWDdLFhdbzdRRFhJFLLRF\n" +
            "cltCHmCBmtSlgjpllgGvTwPZPMfZvPsCMCwZvC\n" +
            "FRQQMdlFMDWRFQRQMQQDWdFbSSSVJSBbJSlBVVBnPJnzJL\n" +
            "rsftPfhsrgwznSzzHSLgJG\n" +
            "fhNsjrjhvsTTvdjcCRMRMRPcCW\n" +
            "tRtJttHFrjtDQHHBQMMBgMBSghhZQb\n" +
            "vqWPLpLvqrmPdmqwvqfmPhNBBBlSnbwbgnlnlhNSZZ\n" +
            "pGpdfzLLspddmqsqPvfvvPpGTVcJJCDRjHrccRtDjcRDFD\n" +
            "GJMHCdTMWJRhSTlhhSPllt\n" +
            "fVvqpfBFrqvqNzzgVDFrpDPmSVtQSlSmhjwltlRtmVhn\n" +
            "pzpBNDBzfDrsNsDRJJRdCssMLdLZWZ\n" +
            "hFfvWWvdpCwwcwFhphpcZCMmllHLfmbQlbrQLBJmGgQrQm\n" +
            "nVSNGjGzzSVNTsjzSJrbSrHBSHlrrmQHJB\n" +
            "PttTNsTRVnNjNqRnzRzRWCCCcpMCWGPMwwFZvFwW\n" +
            "DvZbFnDDsqDBwwRQgNBm\n" +
            "HhWpWWRMWChlChdHLlGlGtQtggSNPSSpgPmNgPJQtw\n" +
            "CMlWGMhhCVHlLCdHTHdrGHdbzjVqnzcvqqjRjFbbzbFFqR\n" +
            "ZZgCNqqBmjZsNgZCqJgNBdrLFHbBrWlPdHWFbPnHPW\n" +
            "TVwTDfzDwSDzmcSTcrzdbllnHPHdFlLzbF\n" +
            "tvDQwVtVvDVmtRsNMgRpJg\n" +
            "BBpDCpNJnmnpnDDmDGGmtTzqHcGTvTTjTbGjHLVcLb\n" +
            "swNNhPwwHzTVwwHw\n" +
            "rPRlPRhSQmmBDpnNfl\n" +
            "pbRhffPzcPDmfcNTpVBLpBjMGBGjZLLg\n" +
            "ssrCsqrszgJjZMqZLQ\n" +
            "SzCwnsllCrssvdrvwzPmDmPPbFRbSThPTPDD\n" +
            "QWLfcfczQQpcDTpLPfdZRRvRRVqbFWvZbvtqvv\n" +
            "NsGGJBhCmNdZVqsbdssZ\n" +
            "rMwwwBBJMrdzPfQMpzMnLQ\n" +
            "rdtCQhrCtQQprtTWQCHFjPgGBPdFPgvBqRRPqB\n" +
            "lsVsSnVSbLmmgBcgTLTFGgvq\n" +
            "wTTDTszsbzMDppJrJhDQ\n" +
            "ZlmsGLBVCBBZFCFFHqcHVvQhqVQSSHpH\n" +
            "dbbTRMrRwwzDfrTbFtMvcptvHFQQpqtc\n" +
            "gdJTDWgfwDwTwmgmNPnNsgFBlZ\n" +
            "PWhWhGFzzzrLdHCPccbJQJcHPD\n" +
            "NRpVTpTgRWVlHJNHMcHQMb\n" +
            "pSRSpVSZWRSTZjgTRTWnFLdZLrrndhdzZvtvzn\n" +
            "LgctLgVBVLhlPjqRhBLVcVlhbDDcGnNGfwCrbNDnrGbGCJNw\n" +
            "HmppHMWWmQmMqZZHWQrDDfDCffJrDGJrCb\n" +
            "qpWZsZZZMZWTLPhTRgTtThRP\n" +
            "hfhQfFQWzBfhfTQdmzdLDtDjtvHLjt\n" +
            "qsgpcqMNRmgpqsCwpCmZDvjwvdddHZHvZDtrrd\n" +
            "SgmNmqScbTSJbhJQ\n" +
            "dvMTQvTnZJsrQdbbSvMVZMblDwlflfDGgwwHcfGjPfjjrG\n" +
            "FqBLpBpFpFzRzqNFmgjGlDRHcwPPGwgcgs\n" +
            "tLNtWshsLLqWMJhTQVVbhvJd\n" +
            "bgZLMZgzbbLCcPCbMZbcNMgBqSTqSWVtSzvvTTBTqBvRBW\n" +
            "FhQpJQnGrlhGlrnTqRtTRJqSwDwtVR\n" +
            "FqlnnFnqFHnGHHdNZdbZbCNMdPLMPb\n" +
            "HHFnbftcfnfbbTbTnHTNVZZzJlPQlFrFzVJFZsdr\n" +
            "mvpGCBgwqCvLCqvMQWWzsQQWlPzwzsrV\n" +
            "hpGSGgqSvqbHcnhfVfct\n" +
            "lGVrnHsGcnVHzscrlGjHcrHqqWPlJCPJClTLLqCSPLPdqS\n" +
            "fRbwbtMQZtMMRFMSqfJTTWCTJPJCmd\n" +
            "ggdvtvdbVVGnpDGg\n" +
            "BnBjTcbnvhjjlMnNJJfnDnQDGdNDfP\n" +
            "qwFqVSWwqLpWFmFVCSqFpDDCJNJRQTRfRDGPfdfDQN\n" +
            "zwHwWVVWWFSqqwWTLqzzztHMvBhlcghblMlcttMllh\n" +
            "PFFNPNPmlFllbctNLmcjBstrsVrQHJSSHHSnnB\n" +
            "fddfDhdwGhTWWTDMwMggssjsjndsBsjsnSrVqSVV\n" +
            "MCvvTWvRMwCvGPpzCcmbplpCVC\n" +
            "thTqlPPTNbGNhGdqRRhRrNtFWnDnvvFZDpnFvfQDZtvWvv\n" +
            "HcMzVcVVcHrgHzcMcmmgfQvFQnMjnWDjfnvjQFfQ\n" +
            "VSmHJLHBJrTrJTlT\n" +
            "NjnsHjLLjNRddNdBFBSR\n" +
            "ftsbqfDcDqsrDtqsfSVBhJVFJgdBRVFS\n" +
            "wvDqwtDlsDDczjzjHvLzLQQM\n" +
            "qDwstwDtRfpJfVhBVZBMvnlRvv\n" +
            "zSFzQHFWdgZBVTZhTzrp\n" +
            "NHdggjGjWHQFPWHNPPbpJfPDtCwCtqDqJfbt\n" +
            "pvnbqHvnTvlCCpjsBsMGBGWWPp\n" +
            "RJSJhJCRVJmJwScrhSJdfwFsBGhZBjhGFFFFGgFPGhZW\n" +
            "cdRrdmwtfcdSmLtcSCQlvQNqQTlqqvtTlv\n" +
            "rnSlSrgWjVGpTTRhSffpRd\n" +
            "HtgHPsNNgNHszPcTBphMdhHhBcTc\n" +
            "JNNbZPZZsszNmtDbPgsmJlwFvWVnCwrlmWlnjnGvCC\n" +
            "WrVBVgVGGQCrSTTqvVjDqDjv\n" +
            "FmwRRwwRQhhLFMjFMzdqSSzS\n" +
            "RcJtbnnLtQWrGHcfrP\n" +
            "vpzssjmVjVZWNZzzQwtQwccpQhgtQCct\n" +
            "qDdfLMnMrrTbBLqTqltlTfbGQnghgRwggGgRnhhccCJJcG\n" +
            "MtdLfSSSddMftlrjjzsSWVSjFvjNvs\n" +
            "qTRPpRPzJglzGJzpGRHWHljwDtbwffjtbhjfwNfHmwwf\n" +
            "SZLVdsvrrdFdBcdZvsBdDCNtbmftNwfNbNhCNvtz\n" +
            "MLzzddLsQRppRlQGPq\n" +
            "PDDpdJgtpppGgttgdGdgJFzLjVcvVnnCTrVrRPTLvwnTTC\n" +
            "ZSbHBsSNlZcsfNnnvRrnVjrHwvCC\n" +
            "NmSmsfsfhmzcDmctJW\n" +
            "NbrLfrrLqpqWQHtBzbFttJgcgB\n" +
            "CmwjPPjjjShPvljwvwwjPBFttBtcHzFJcHTRHJRRmT\n" +
            "CCljjDGhvPCVdVSCdPvrrNfnnQsGqMpqqMqnFW\n" +
            "bdPdbcDZlddsZbHjrrgrmZmCZhCGjv\n" +
            "BffLfLVFVMMBRfwMpfzhFGFhGWvWvrhNvvNj\n" +
            "RMBpRSnffBJjSbJqdPHsDcbqtl\n" +
            "BgwGwDDZttDDTNND\n" +
            "WzNNnFRWFtTFlFsh\n" +
            "WJjPpPqqzWRbrqnNqvVvgvvdcBwgdrVBZG\n" +
            "FFbMVMFPvJppgvcvrZMjHlCJWHmHHBlqhCmqChCl\n" +
            "RGQVdVVLnLsQnQnnqWBlBmDRBDWWlhBD\n" +
            "SftLzQndGfVgFfjvvM\n" +
            "npvLlFLTWWqdLnJCmBmmpjQjjmjB\n" +
            "tfgDwzwVVVVtgtrsJtrbjSPQjQmjNBCNBNhPHDHC\n" +
            "ggVzVtMRgzMrvJLqFnnRnnRT\n" +
            "gZFZssWgNZTDwHDWzsFwWDQMMpqqpBPMjFtMPSQFqqqM\n" +
            "vrmvhdnVvQpftStnMN\n" +
            "JCdLddhhdJdcCdrrmCGhlgNsWDWDwWsgwHgHLZHW\n" +
            "vSsSGjSPvjvRSGpFprFbqFpppRfp\n" +
            "ZdmlndtBZbwrwfpWFn\n" +
            "JmdHdBBHtgllZldBhJZldLLBjPVQTfvGPNzQQSjjzPgTGNTs\n" +
            "TjTjBjVrTsLRRrMBsMMgzLqGGqgQHQdCQGgpgd\n" +
            "nbZcmNnPNcbNftvhlhZpgQgCqdSpgCHCqPFzSH\n" +
            "WfcNvtmmNmQlvNcbsWWjMwMVMRDVMDJM\n" +
            "hHHnfZSwHDgHcfclSGSnvrnvBCvWWntvzvzbWWVq\n" +
            "dTJTmspFTsFdRRLvtvLzvvVqtPVtrb\n" +
            "VFMNFpRJNTppTpsJVRcMGgfGfgZwghgGfcGh\n" +
            "lLGvwsMJLCMVnTrCrVdHRd\n" +
            "tbzqtDNNBpNWBtqzfRrFFnrVTTdrQVSVGp\n" +
            "tztfzmfzzPDzgWNNBbhGMlJLsvhJJjGJhGmM\n" +
            "rHrVJQVQVJLggDQQLbTvdCCSTdWLLLbCbS\n" +
            "pNtnwPthmZGRpmPFtqbMSzqffFSdTvbSzW\n" +
            "GpvvshwtmwsZDljjssHjVBVj\n" +
            "SmhJdtJhhzQSrzVhtQbtBRNfnFNSnDNGRfFGGMgR\n" +
            "lHwqPjqwTjLHCWLvPpvNrNMvnNGNfNGNBffGRN\n" +
            "lCrPTrwpPZWlqPlqpWWqZjsmJzbzVtVhhdsJcQdddZVJ\n" +
            "QqpCWHdQdVQlWcQCqcfRjnZZZPDnSPqPhhqZ\n" +
            "tmmzgWGgwJwwStSZZDRnZssR\n" +
            "GbFbLLvgmMMwGgmLCrppQrWVlWrFTHHd\n" +
            "qdqCgSVdVSVqfwsdZhpJspZsph\n" +
            "RjZBbmRlrlmmJwLNNNhLpwhB\n" +
            "vZlRrtTZCzCMfSPT\n" +
            "JBjhCNwjrlJlHJJRsscZrTcvLLgTsLPP\n" +
            "dDztmntCSgbLgqTzgc\n" +
            "fGVWnSMFtVGMNNNQllBjWHJC\n" +
            "dSDhVVdVZtnSgHQGThQvFNQQqF\n" +
            "LcfLRpMpcBpbrJfsbsscBNWRNPRGHvqPdTGPGqPWFH\n" +
            "spmrCcrdJJpLLmcmLLLDlzSzCCjVwZVtgnSZzn\n" +
            "ZJtgPTHtZPZQGbtNzzprVWWVrbrpCD\n" +
            "BRlfcRmBhSMVBqSVfBvNWrDrjWCjjzprCDCl\n" +
            "LfMRSmfqfSLcnnMqVSfccnhZwJFHZFTGZQGFLggwZTZGPJ\n" +
            "BChWddRRRcfmDbfhDP\n" +
            "MgpMFFsvMfGwvLgPjQPzPPmDcztDtw\n" +
            "NFgJpqvpLgqFnWWVNSfnNSCR\n" +
            "zMMMRmMfJpfhpzQJLMVtjtjPntgBtlZlVgJP\n" +
            "SdNbZvZbvbHTNbZbSWTdrTVBglBDlWBjDPDgntPqBDPt\n" +
            "rrNcrFwNdSrfzwMzZMLQQs\n" +
            "JPmCSfHTGJdTCbHgpgqLgRhghhffhg\n" +
            "ZWSSFVSVFQghQvwpphgh\n" +
            "lsDtZjVMMSdCNdbGCbjb\n" +
            "PBQPvDvVVRvQDqLDzJTlzwjz\n" +
            "tGcZTcdgGcncdrFrsTjzJSJqJqqwHSzzSZwq\n" +
            "CgtgdFgcFCMnMgsGFGGQWPQpQTCBvbNpNVVWVT\n" +
            "FHVFWMHMgVhnLWWMpnppfcdZNcPplnfn\n" +
            "RSvSCBSqGgDRjqCpPlPpppTpPjlcNP\n" +
            "zRzsGgJDqJwLVWVFwM\n" +
            "ThhWhNthVWTWqbWbFWbTdBtWSdMlHSlGlCGCdsCMClmnSlMn\n" +
            "DPPpvvfDHfLgDHvzpvPDsssMsmmzsMcClScMMcGG\n" +
            "rgPLHHJJHgZfvvZQQZfrpfFqBBwFBTNTBNBwtthQwVqt\n" +
            "JJgSWDSmSDQCFrhbRLSwLS\n" +
            "VznqzVNsMsZLdqslbRChtbHdHRrwHb\n" +
            "LVfNLMsLTmWDpBpf\n" +
            "cbTsnNpcnnchllFQlMRgJhRP\n" +
            "WddmdMVSBMWSBWjwCJVCPRwPFCQRRC\n" +
            "DWSSfjdSrTpDnHHMbZ\n" +
            "fgsVqqwQQtHhCrDfJH\n" +
            "pvbnBZWBbvWbTdthrJbDmqrmHq\n" +
            "TvZSNSNNSvFMBpqpnLnTBZBFGQwlQFggcFzcVGRlswsRll\n" +
            "zfMcQHzPtRNvlllc\n" +
            "BLnMhbZMLJLNNVtCdNgZgt\n" +
            "BJGFpqMBhBLLMqnwBhbrbhLssjFzssjfDzsmFmjmQFQPjT\n" +
            "JPBJPnpBFrqBJHtjlCjHJcCthM\n" +
            "wQZggQWQGfZFVmmGfDRjlvvNcvlNDhcNttlctt\n" +
            "SfmWfwVFwVGZWQVGSTdTbBpTPSqBbLnnrn\n" +
            "RJqBRJbqpqqJGvqHMmcfczfcjvHQfm\n" +
            "llgVnSWSlsssTnlWjhTcsZMcZcZMZMcccMNmcH\n" +
            "TnFhhllnWCnVCTllLnhhVSrbDDPrdpjRRqjBPRBBpbFJ\n" +
            "mRwRRNDjNTqwDNjNnNRTsQLcQWpQWZJLlLpQWs\n" +
            "PMFGCSzzgbBVzCGShVQZcgWsQLLftttQtlZZ\n" +
            "SlGVldCGGbBPMhPCVSBrNNdjRqjDrNmDnmrRwN\n" +
            "mqGGqGHnqGBCMrnGCbbbLgTTFFNNghHNTj\n" +
            "SdRfcsDPPcDdRzWPWltSlscwTSbShhgpQhgbFLbTQFjwhN\n" +
            "DPWWZzzztsDDtfzlscsPdcWZnVMNVqqGJnBrVqCrMrVvZnBJ\n" +
            "ZgglFCrrrlrWCJswHmwRVmFSwSsP\n" +
            "zhzqBLcjjnpzMzjhTtcqnVGbwssVRmqbHNPbwPsVNH\n" +
            "ftBjzLtptRWdvZlQQZQf\n" +
            "nGpsMncVRMGSnfsBllZdppwrTljZrQ\n" +
            "gcgHmtbCthHWhwBFBWZBlWlWrd\n" +
            "bCDDqHhcqbbtqcqtvJMzsGRsvVfPsfnzJV\n" +
            "TclPvSGZsPZRjhjWDgjp\n" +
            "JtnwHFtJqtwfQfgWgRWhdhjtgdRM\n" +
            "JBwnHwgFFqVJrsGmPvNTPsVvSN\n" +
            "ZJnfZNnDNZJLzNntDtDNNzNWTVBPrrvRRGdBcVRfPPcvfdMr\n" +
            "CFgjFmggQSQQmSggVMMvRdTvBVRjrdrc\n" +
            "mbsqQFqFgwwmgmSbwQWWLDWzpLcLnzZzLbLL\n" +
            "PnwSFSLSTwbbHdtstW\n" +
            "RrDZVVfJNZCmDCfVDVlblZHbddtHScbWbMjt\n" +
            "NmzqhzCCqmzffhCCqrhhLLnPvpnTPPgpGTTBSL\n" +
            "ShhfLSDDFMPQddpMrDgNbjzffqqqzgcjbqZR\n" +
            "sCstmwJwVBtmTltVmTVbRbcbcRvqvrZvBRvZbR\n" +
            "VwCnwnVrrrWShWPHHDdQFL\n" +
            "pbpDpWjZMmFCmmmb\n" +
            "jTjtJLJgJncCFmnJFC\n" +
            "LvhvhTQhBSdRNtLNsSszlGrHSGjZDlGf\n" +
            "JrhvTNJJhhCrtVtcrNLwDBSBwqzDwQVbBLQS\n" +
            "RnCgHmHHGMdPsGMfDlDqlSQbQnQQDbzD\n" +
            "RdPMPsmWHmjfMffPcCWrptcprpFTFrFp";
}