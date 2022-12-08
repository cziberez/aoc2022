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

    private static final String STRING_INPUT = """
            shzsFcPssFhjFssBzdpRcNHNZrpdJdJVJZ
            fwvMCntfCCbSbSbtDgDNrDtDtJHZVH
            GbCwwbwwnGrLhBzjFFFsWPhL
            PpCqRsqqmmtCwMJC
            LHFrLLHDSNHlfWNhDzmjzzJlJzPJMvPJjQ
            SGSWDNrhZhPDSWDZLgVVRgbRppgpGVnpnn
            GRRjbVjmJZlgMRzzrN
            FpDptHpfHfnpPTvDFTWpFPnPcMfNCClNrzcVcrMMzVsCZlsZ
            TFTQDnvLHPFDtVbLwbjdGjdwwJ
            lhljvvhCjjzhjszzBPmnmGVZMGzG
            FbTcTwbtSFdtcMPnTBPQVnnBZT
            SFMpHDtNDSSbSdwppvgJWjJCJJgWgvlJHH
            wzNCWpzCzJnWWpRRNdJrgHLhjfbLrHrchV
            lBMStmPmmLQDPQZlshrdhgrfrcrrddgHgs
            mvGDGQSvDPBlGMLGCvCWpNvpzRWFwqRw
            stBttBThtDZqPWssPWZp
            gRggwwggCGFSBBvPRpHZZrHdZLZq
            ccFJGCNJmmGQzbTDhnQhBBnB
            HJqMqtZbJMmJTqtLtVMqhpfphNdQfhfzzjhhlHll
            rWSBrnwFwWCvwWCwBgPgCgzjQccQhhgRzcdQzjfcNfzR
            CWBCwCvCvvwssWLMtJJGMdMZJsGV
            nFwSFQwsNrrsssSwCrhrCNnfcCRgJRMJTJcMfRzMCMCRvW
            DdbGdLZLttllWWvTzgzzgR
            ZqGzPdLtDjBjDZGPZVmnhQFwqrFQhVFnss
            sNNpCjttjsJjSpgpWjslCTnqqSVffrnhSfDhmhrhfm
            dBwcGzbPBHbbwZcwJbcTTFDFFFDVrdVmFdnDqf
            HzGcczQPHGwzPzGHRctWlvRgtvJlvNlJvRNj
            cFNCFdvcCHvFBCZcwBfRSpttGhDmCghGShmSRt
            QjLnTTzQVzTTnLMqhDgPhGDDSjGPrgSh
            TTJGnJJlLQdNWZWJNBJZ
            WHBpHcMDZHLDbHLtGCnmRmLNGmRqvsCC
            PzTFzPPTJzrSbGsvnmqfsqfqRz
            dJSQQdVFQgjTrjQPWcWHbBVcZVccZtWp
            JDtnRtJzNzTTNlHc
            rQPJFrLPGMMwrGPFwjFMVLjSTWHdWBTdSWdWZlcWTHlZ
            MGFrCvLLwrwPFVVhvLMGGtnqfsmRJgDnqbRgfbqmfC
            jnTtFjcSSvctJjznzvFmpqqPMqQDRVpRqPzqQzVQ
            bhHBfrWpfHsfGNllRrRCPqDCqPqq
            gsGZZpbWgbwHWGNgfZNjvLSTTjtnTgjSSSSJmL
            RLQNdVNnRQdQHVVLGpspNqvtsqptqpTtsp
            MlRWwbRBBFMFjCTFTTFDvj
            WmlWBmBwwmrndnmLRHRQ
            WnftJWlfnWSHGCjWWWSCFqFGBDqBwMcDmmMmGmqD
            pTNhpTrPhhhRPzbhrppLhThLgqDmwccwqPBmMMqnFBcwwmBB
            ZrhQTpzdjSVVtnvZ
            jgtnJtBjtlTdJBZJVQBngQGDCGWpPGCcPWCbWdWMbcpP
            wHstNNttSHPDmHcMCp
            rrFFSvLLNfsFtNSqrtfrhsNjjVTBVgVvnTBvTQvjTgjVZz
            qhZwlqFqFwlJwrDHqHcDvgcNzv
            RCCTQmjCbQTBtRTbjJRDpBrgDHPPpPDvHccDPc
            VmjVWstQJhlJlGVJ
            GggpGwZmgvgJMvbJFQQDbDFbBbFCQDCW
            rtrLzNLtNSPnNqDSQDcQCWlqBQ
            VtzdRPtztLtVRtZmmMTRwCGZpMwp
            vtvqjsCqtshfjcWFHWGjGFJj
            zGrnzDDMpPcTHcSTVTJP
            DbDwMbZRDrZdBBnMznZMGZDfwtlgQhsqCttClsqvsLfCff
            JLzLtLsrzsQdvrWRwMHwcc
            qPmCTzlPjljjFTZmWwcwwvHMMRWwHvMm
            PFqZnVCqTCNjCzNgQsbGBLzLQQ
            CBnppDHllVpPCBshBHpjDTSmZcSrfwvmJcDDTJfw
            dFRLdLFQzNSTBTSNmBJv
            FzFFzRMBFWtQlPlsjjPVMnhC
            CVCfwnfdVvBdBbTNTT
            LNzsHPNWsDjTZqDHqT
            PtLgQsGQLSzWLstPgGWcgQLSNrpplffrnrNhpVCwlGVlrwMn
            jPPVqPsHffzVnHzvSgMcCJGGMSVCll
            pdbpDpBLNmNNppJgcvgSllGjDSGQ
            hrbBwLpjLhhhNZLhNrhZZLHzfsztFzzsrtHfRFnFfRHf
            tdjBdbmSfdHBdHHmZlWjFrnlWQlqvMFvFn
            pDNDJhLhPVPLLLJphJLwNcwnQTcWWTqTrqMWTZvqMrlvFM
            gpVLhNwpgZJCghCLDNwphgmsBdzHHHmSstmfggzdbR
            TfMpfMBVftLMDBSjWDHgzHbgwLgHHvdzggzs
            QJnZcFFnZRHdHjJvwgdg
            RjjRRnmNmmZNjZqZnQcVffBrWqVTqrtffTSTVV
            fZTdTVcVjrjdBzdTnGtgnnGSHHNFGn
            thMWPtPMslmGnWnNnS
            thvbMvQMRphhLCjrzBjZVdcQfC
            MpmgZFgMGdrFrBCVnJ
            JsbJlTTlvLQbVffRRvBBRVjd
            LWlbhHlJhLTJmmGcMMHNmNgN
            bhvmhPrbhqNqQRRGzQjVvvRL
            wTwBZDBTwwggfnngcDfdsVVFQCdzCzDVRsFdQs
            pngWMcgzMgpZWncnMpWNrbNHrNbmHhltWlbl
            nPndBjLPscWSccBVGnScsSzMdhMppMthdMgpMgrzvhhp
            CCFTFDwqZqCCJmhvpDzztVzDNztp
            qQFJTbRVbmCfwTwfmnnssWBGnLnWlRLSGn
            JRlJDSvLRRCdvmDSvdlbZNVBSWZGNgWsZGNgZBVs
            QrjPMqMnLzzjLjFnNNgBpsgtgGGGVZ
            hrjrFqjqFrQfMHPhQzDvvCLJdwwwmvbJbwDH
            HDGrDDDpNsGQNdZQ
            jpjgtgjSjpjllfZZtZsvNdtshqqq
            cbgMfjclWTJcMwjWJfpfmVPLPBnVBHnmVbnmLBbD
            rPrMZNsNrsvrwqvFFFdgQWNzLJJzRW
            pStppStHmcmHpgVSllVcbVbWWDdLFhdbzdRRFhJFLLRF
            cltCHmCBmtSlgjpllgGvTwPZPMfZvPsCMCwZvC
            FRQQMdlFMDWRFQRQMQQDWdFbSSSVJSBbJSlBVVBnPJnzJL
            rsftPfhsrgwznSzzHSLgJG
            fhNsjrjhvsTTvdjcCRMRMRPcCW
            tRtJttHFrjtDQHHBQMMBgMBSghhZQb
            vqWPLpLvqrmPdmqwvqfmPhNBBBlSnbwbgnlnlhNSZZ
            pGpdfzLLspddmqsqPvfvvPpGTVcJJCDRjHrccRtDjcRDFD
            GJMHCdTMWJRhSTlhhSPllt
            fVvqpfBFrqvqNzzgVDFrpDPmSVtQSlSmhjwltlRtmVhn
            pzpBNDBzfDrsNsDRJJRdCssMLdLZWZ
            hFfvWWvdpCwwcwFhphpcZCMmllHLfmbQlbrQLBJmGgQrQm
            nVSNGjGzzSVNTsjzSJrbSrHBSHlrrmQHJB
            PttTNsTRVnNjNqRnzRzRWCCCcpMCWGPMwwFZvFwW
            DvZbFnDDsqDBwwRQgNBm
            HhWpWWRMWChlChdHLlGlGtQtggSNPSSpgPmNgPJQtw
            CMlWGMhhCVHlLCdHTHdrGHdbzjVqnzcvqqjRjFbbzbFFqR
            ZZgCNqqBmjZsNgZCqJgNBdrLFHbBrWlPdHWFbPnHPW
            TVwTDfzDwSDzmcSTcrzdbllnHPHdFlLzbF
            tvDQwVtVvDVmtRsNMgRpJg
            BBpDCpNJnmnpnDDmDGGmtTzqHcGTvTTjTbGjHLVcLb
            swNNhPwwHzTVwwHw
            rPRlPRhSQmmBDpnNfl
            pbRhffPzcPDmfcNTpVBLpBjMGBGjZLLg
            ssrCsqrszgJjZMqZLQ
            SzCwnsllCrssvdrvwzPmDmPPbFRbSThPTPDD
            QWLfcfczQQpcDTpLPfdZRRvRRVqbFWvZbvtqvv
            NsGGJBhCmNdZVqsbdssZ
            rMwwwBBJMrdzPfQMpzMnLQ
            rdtCQhrCtQQprtTWQCHFjPgGBPdFPgvBqRRPqB
            lsVsSnVSbLmmgBcgTLTFGgvq
            wTTDTszsbzMDppJrJhDQ
            ZlmsGLBVCBBZFCFFHqcHVvQhqVQSSHpH
            dbbTRMrRwwzDfrTbFtMvcptvHFQQpqtc
            gdJTDWgfwDwTwmgmNPnNsgFBlZ
            PWhWhGFzzzrLdHCPccbJQJcHPD
            NRpVTpTgRWVlHJNHMcHQMb
            pSRSpVSZWRSTZjgTRTWnFLdZLrrndhdzZvtvzn
            LgctLgVBVLhlPjqRhBLVcVlhbDDcGnNGfwCrbNDnrGbGCJNw
            HmppHMWWmQmMqZZHWQrDDfDCffJrDGJrCb
            qpWZsZZZMZWTLPhTRgTtThRP
            hfhQfFQWzBfhfTQdmzdLDtDjtvHLjt
            qsgpcqMNRmgpqsCwpCmZDvjwvdddHZHvZDtrrd
            SgmNmqScbTSJbhJQ
            dvMTQvTnZJsrQdbbSvMVZMblDwlflfDGgwwHcfGjPfjjrG
            FqBLpBpFpFzRzqNFmgjGlDRHcwPPGwgcgs
            tLNtWshsLLqWMJhTQVVbhvJd
            bgZLMZgzbbLCcPCbMZbcNMgBqSTqSWVtSzvvTTBTqBvRBW
            FhQpJQnGrlhGlrnTqRtTRJqSwDwtVR
            FqlnnFnqFHnGHHdNZdbZbCNMdPLMPb
            HHFnbftcfnfbbTbTnHTNVZZzJlPQlFrFzVJFZsdr
            mvpGCBgwqCvLCqvMQWWzsQQWlPzwzsrV
            hpGSGgqSvqbHcnhfVfct
            lGVrnHsGcnVHzscrlGjHcrHqqWPlJCPJClTLLqCSPLPdqS
            fRbwbtMQZtMMRFMSqfJTTWCTJPJCmd
            ggdvtvdbVVGnpDGg
            BnBjTcbnvhjjlMnNJJfnDnQDGdNDfP
            qwFqVSWwqLpWFmFVCSqFpDDCJNJRQTRfRDGPfdfDQN
            zwHwWVVWWFSqqwWTLqzzztHMvBhlcghblMlcttMllh
            PFFNPNPmlFllbctNLmcjBstrsVrQHJSSHHSnnB
            fddfDhdwGhTWWTDMwMggssjsjndsBsjsnSrVqSVV
            MCvvTWvRMwCvGPpzCcmbplpCVC
            thTqlPPTNbGNhGdqRRhRrNtFWnDnvvFZDpnFvfQDZtvWvv
            HcMzVcVVcHrgHzcMcmmgfQvFQnMjnWDjfnvjQFfQ
            VSmHJLHBJrTrJTlT
            NjnsHjLLjNRddNdBFBSR
            ftsbqfDcDqsrDtqsfSVBhJVFJgdBRVFS
            wvDqwtDlsDDczjzjHvLzLQQM
            qDwstwDtRfpJfVhBVZBMvnlRvv
            zSFzQHFWdgZBVTZhTzrp
            NHdggjGjWHQFPWHNPPbpJfPDtCwCtqDqJfbt
            pvnbqHvnTvlCCpjsBsMGBGWWPp
            RJSJhJCRVJmJwScrhSJdfwFsBGhZBjhGFFFFGgFPGhZW
            cdRrdmwtfcdSmLtcSCQlvQNqQTlqqvtTlv
            rnSlSrgWjVGpTTRhSffpRd
            HtgHPsNNgNHszPcTBphMdhHhBcTc
            JNNbZPZZsszNmtDbPgsmJlwFvWVnCwrlmWlnjnGvCC
            WrVBVgVGGQCrSTTqvVjDqDjv
            FmwRRwwRQhhLFMjFMzdqSSzS
            RcJtbnnLtQWrGHcfrP
            vpzssjmVjVZWNZzzQwtQwccpQhgtQCct
            qDdfLMnMrrTbBLqTqltlTfbGQnghgRwggGgRnhhccCJJcG
            MtdLfSSSddMftlrjjzsSWVSjFvjNvs
            qTRPpRPzJglzGJzpGRHWHljwDtbwffjtbhjfwNfHmwwf
            SZLVdsvrrdFdBcdZvsBdDCNtbmftNwfNbNhCNvtz
            MLzzddLsQRppRlQGPq
            PDDpdJgtpppGgttgdGdgJFzLjVcvVnnCTrVrRPTLvwnTTC
            ZSbHBsSNlZcsfNnnvRrnVjrHwvCC
            NmSmsfsfhmzcDmctJW
            NbrLfrrLqpqWQHtBzbFttJgcgB
            CmwjPPjjjShPvljwvwwjPBFttBtcHzFJcHTRHJRRmT
            CCljjDGhvPCVdVSCdPvrrNfnnQsGqMpqqMqnFW
            bdPdbcDZlddsZbHjrrgrmZmCZhCGjv
            BffLfLVFVMMBRfwMpfzhFGFhGWvWvrhNvvNj
            RMBpRSnffBJjSbJqdPHsDcbqtl
            BgwGwDDZttDDTNND
            WzNNnFRWFtTFlFsh
            WJjPpPqqzWRbrqnNqvVvgvvdcBwgdrVBZG
            FFbMVMFPvJppgvcvrZMjHlCJWHmHHBlqhCmqChCl
            RGQVdVVLnLsQnQnnqWBlBmDRBDWWlhBD
            SftLzQndGfVgFfjvvM
            npvLlFLTWWqdLnJCmBmmpjQjjmjB
            tfgDwzwVVVVtgtrsJtrbjSPQjQmjNBCNBNhPHDHC
            ggVzVtMRgzMrvJLqFnnRnnRT
            gZFZssWgNZTDwHDWzsFwWDQMMpqqpBPMjFtMPSQFqqqM
            vrmvhdnVvQpftStnMN
            JCdLddhhdJdcCdrrmCGhlgNsWDWDwWsgwHgHLZHW
            vSsSGjSPvjvRSGpFprFbqFpppRfp
            ZdmlndtBZbwrwfpWFn
            JmdHdBBHtgllZldBhJZldLLBjPVQTfvGPNzQQSjjzPgTGNTs
            TjTjBjVrTsLRRrMBsMMgzLqGGqgQHQdCQGgpgd
            nbZcmNnPNcbNftvhlhZpgQgCqdSpgCHCqPFzSH
            WfcNvtmmNmQlvNcbsWWjMwMVMRDVMDJM
            hHHnfZSwHDgHcfclSGSnvrnvBCvWWntvzvzbWWVq
            dTJTmspFTsFdRRLvtvLzvvVqtPVtrb
            VFMNFpRJNTppTpsJVRcMGgfGfgZwghgGfcGh
            lLGvwsMJLCMVnTrCrVdHRd
            tbzqtDNNBpNWBtqzfRrFFnrVTTdrQVSVGp
            tztfzmfzzPDzgWNNBbhGMlJLsvhJJjGJhGmM
            rHrVJQVQVJLggDQQLbTvdCCSTdWLLLbCbS
            pNtnwPthmZGRpmPFtqbMSzqffFSdTvbSzW
            GpvvshwtmwsZDljjssHjVBVj
            SmhJdtJhhzQSrzVhtQbtBRNfnFNSnDNGRfFGGMgR
            lHwqPjqwTjLHCWLvPpvNrNMvnNGNfNGNBffGRN
            lCrPTrwpPZWlqPlqpWWqZjsmJzbzVtVhhdsJcQdddZVJ
            QqpCWHdQdVQlWcQCqcfRjnZZZPDnSPqPhhqZ
            tmmzgWGgwJwwStSZZDRnZssR
            GbFbLLvgmMMwGgmLCrppQrWVlWrFTHHd
            qdqCgSVdVSVqfwsdZhpJspZsph
            RjZBbmRlrlmmJwLNNNhLpwhB
            vZlRrtTZCzCMfSPT
            JBjhCNwjrlJlHJJRsscZrTcvLLgTsLPP
            dDztmntCSgbLgqTzgc
            fGVWnSMFtVGMNNNQllBjWHJC
            dSDhVVdVZtnSgHQGThQvFNQQqF
            LcfLRpMpcBpbrJfsbsscBNWRNPRGHvqPdTGPGqPWFH
            spmrCcrdJJpLLmcmLLLDlzSzCCjVwZVtgnSZzn
            ZJtgPTHtZPZQGbtNzzprVWWVrbrpCD
            BRlfcRmBhSMVBqSVfBvNWrDrjWCjjzprCDCl
            LfMRSmfqfSLcnnMqVSfccnhZwJFHZFTGZQGFLggwZTZGPJ
            BChWddRRRcfmDbfhDP
            MgpMFFsvMfGwvLgPjQPzPPmDcztDtw
            NFgJpqvpLgqFnWWVNSfnNSCR
            zMMMRmMfJpfhpzQJLMVtjtjPntgBtlZlVgJP
            SdNbZvZbvbHTNbZbSWTdrTVBglBDlWBjDPDgntPqBDPt
            rrNcrFwNdSrfzwMzZMLQQs
            JPmCSfHTGJdTCbHgpgqLgRhghhffhg
            ZWSSFVSVFQghQvwpphgh
            lsDtZjVMMSdCNdbGCbjb
            PBQPvDvVVRvQDqLDzJTlzwjz
            tGcZTcdgGcncdrFrsTjzJSJqJqqwHSzzSZwq
            CgtgdFgcFCMnMgsGFGGQWPQpQTCBvbNpNVVWVT
            FHVFWMHMgVhnLWWMpnppfcdZNcPplnfn
            RSvSCBSqGgDRjqCpPlPpppTpPjlcNP
            zRzsGgJDqJwLVWVFwM
            ThhWhNthVWTWqbWbFWbTdBtWSdMlHSlGlCGCdsCMClmnSlMn
            DPPpvvfDHfLgDHvzpvPDsssMsmmzsMcClScMMcGG
            rgPLHHJJHgZfvvZQQZfrpfFqBBwFBTNTBNBwtthQwVqt
            JJgSWDSmSDQCFrhbRLSwLS
            VznqzVNsMsZLdqslbRChtbHdHRrwHb
            LVfNLMsLTmWDpBpf
            cbTsnNpcnnchllFQlMRgJhRP
            WddmdMVSBMWSBWjwCJVCPRwPFCQRRC
            DWSSfjdSrTpDnHHMbZ
            fgsVqqwQQtHhCrDfJH
            pvbnBZWBbvWbTdthrJbDmqrmHq
            TvZSNSNNSvFMBpqpnLnTBZBFGQwlQFggcFzcVGRlswsRll
            zfMcQHzPtRNvlllc
            BLnMhbZMLJLNNVtCdNgZgt
            BJGFpqMBhBLLMqnwBhbrbhLssjFzssjfDzsmFmjmQFQPjT
            JPBJPnpBFrqBJHtjlCjHJcCthM
            wQZggQWQGfZFVmmGfDRjlvvNcvlNDhcNttlctt
            SfmWfwVFwVGZWQVGSTdTbBpTPSqBbLnnrn
            RJqBRJbqpqqJGvqHMmcfczfcjvHQfm
            llgVnSWSlsssTnlWjhTcsZMcZcZMZMcccMNmcH
            TnFhhllnWCnVCTllLnhhVSrbDDPrdpjRRqjBPRBBpbFJ
            mRwRRNDjNTqwDNjNnNRTsQLcQWpQWZJLlLpQWs
            PMFGCSzzgbBVzCGShVQZcgWsQLLftttQtlZZ
            SlGVldCGGbBPMhPCVSBrNNdjRqjDrNmDnmrRwN
            mqGGqGHnqGBCMrnGCbbbLgTTFFNNghHNTj
            SdRfcsDPPcDdRzWPWltSlscwTSbShhgpQhgbFLbTQFjwhN
            DPWWZzzztsDDtfzlscsPdcWZnVMNVqqGJnBrVqCrMrVvZnBJ
            ZgglFCrrrlrWCJswHmwRVmFSwSsP
            zhzqBLcjjnpzMzjhTtcqnVGbwssVRmqbHNPbwPsVNH
            ftBjzLtptRWdvZlQQZQf
            nGpsMncVRMGSnfsBllZdppwrTljZrQ
            gcgHmtbCthHWhwBFBWZBlWlWrd
            bCDDqHhcqbbtqcqtvJMzsGRsvVfPsfnzJV
            TclPvSGZsPZRjhjWDgjp
            JtnwHFtJqtwfQfgWgRWhdhjtgdRM
            JBwnHwgFFqVJrsGmPvNTPsVvSN
            ZJnfZNnDNZJLzNntDtDNNzNWTVBPrrvRRGdBcVRfPPcvfdMr
            CFgjFmggQSQQmSggVMMvRdTvBVRjrdrc
            mbsqQFqFgwwmgmSbwQWWLDWzpLcLnzZzLbLL
            PnwSFSLSTwbbHdtstW
            RrDZVVfJNZCmDCfVDVlblZHbddtHScbWbMjt
            NmzqhzCCqmzffhCCqrhhLLnPvpnTPPgpGTTBSL
            ShhfLSDDFMPQddpMrDgNbjzffqqqzgcjbqZR
            sCstmwJwVBtmTltVmTVbRbcbcRvqvrZvBRvZbR
            VwCnwnVrrrWShWPHHDdQFL
            pbpDpWjZMmFCmmmb
            jTjtJLJgJncCFmnJFC
            LvhvhTQhBSdRNtLNsSszlGrHSGjZDlGf
            JrhvTNJJhhCrtVtcrNLwDBSBwqzDwQVbBLQS
            RnCgHmHHGMdPsGMfDlDqlSQbQnQQDbzD
            RdPMPsmWHmjfMffPcCWrptcprpFTFrFp""";
}